package lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Employees;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import utils.DependencyFactory;

import java.util.Collections;
import java.util.Map;


public class GetItemFunction implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final DynamoDbEnhancedClient dbClient;
    private final String tableName;
    private final TableSchema<Employees> employeeTableSchema;

    public GetItemFunction() {
        dbClient = DependencyFactory.dynamoDbEnhancedClient();
        tableName = DependencyFactory.tableName();
        employeeTableSchema = TableSchema.fromBean(Employees.class);
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        String response = "";
        LambdaLogger logger = context.getLogger();
        DynamoDbTable<Employees> employeeTable = dbClient.table(tableName, employeeTableSchema);
        Map<String, String> pathParameters = input.getPathParameters();
        if (pathParameters != null) {
            String itemPartitionKey = pathParameters.get(Employees.PARTITION_KEY);
            Employees item = employeeTable.getItem(Key.builder().partitionValue(itemPartitionKey).build());
            if (item != null) {
                try {
                    response = new ObjectMapper().writeValueAsString(item);
                } catch (JsonProcessingException e) {
                    logger.log("Failed create a JSON response: " + e);
                }
            }
        }

        return new APIGatewayProxyResponseEvent().withStatusCode(200)
                .withIsBase64Encoded(Boolean.FALSE)
                .withHeaders(Collections.emptyMap())
                .withBody(response);
    }
}
