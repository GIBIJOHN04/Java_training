package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Employees;
import utils.DependencyFactory;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.Collections;
import java.util.Map;

public class PutItemFunction implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    static final int STATUS_CODE_NO_CONTENT = 204;
    static final int STATUS_CODE_CREATED = 201;
    static final int STATUS_CODE_BAD_REQUEST = 400;
    private final DynamoDbEnhancedClient dbClient;
    private final String tableName;
    private final TableSchema<Employees> employeeTableSchema;

    public PutItemFunction() {
        dbClient = DependencyFactory.dynamoDbEnhancedClient();
        tableName = DependencyFactory.tableName();
        employeeTableSchema = TableSchema.fromBean(Employees.class);
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        String body = request.getBody();
        int statusCode = STATUS_CODE_NO_CONTENT;
        if (body != null && !body.isEmpty()) {
            Employees item;
            try {
                item = new ObjectMapper().readValue(body, Employees.class);
                if (item != null) {
                    Map<String, String> pathParameters = request.getPathParameters();
                    if (arePathParametersValid(pathParameters, item)) {
                        DynamoDbTable<Employees> employeeTable = dbClient.table(tableName, employeeTableSchema);
                        employeeTable.putItem(item);
                        statusCode = STATUS_CODE_CREATED;
                    } else {
                        statusCode = STATUS_CODE_BAD_REQUEST;
                    }
                }
            } catch (JsonProcessingException e) {
                context.getLogger().log("Failed to deserialize JSON: " + e);
            }

        }
        return new APIGatewayProxyResponseEvent().withStatusCode(statusCode)
                .withIsBase64Encoded(Boolean.FALSE)
                .withHeaders(Collections.emptyMap());
    }

    private boolean arePathParametersValid(Map<String, String> pathParameters, Employees item) {
        if (pathParameters == null) {
            return false;
        }
        String itemPartitionKey = pathParameters.get(Employees.PARTITION_KEY);
        if (itemPartitionKey == null || itemPartitionKey.isEmpty()) {
            return false;
        }
        return itemPartitionKey.equals(item.getEmpid());
    }
}

