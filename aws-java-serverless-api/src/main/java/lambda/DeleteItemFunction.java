package lambda;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.DependencyFactory;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import model.Employees;

import java.util.Collections;
import java.util.Map;
public class DeleteItemFunction implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final DynamoDbEnhancedClient dbClient;
    private final String tableName;
    private final TableSchema<Employees> employeeTableSchema;

    public DeleteItemFunction() {
        dbClient = DependencyFactory.dynamoDbEnhancedClient();
        tableName = DependencyFactory.tableName();
        employeeTableSchema = TableSchema.fromBean(Employees.class);
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        String responseBody = "";
        DynamoDbTable<Employees> employeeTable = dbClient.table(tableName, employeeTableSchema);
        Map<String, String> pathParameters = request.getPathParameters();
        if (pathParameters != null) {
            final String isbn = pathParameters.get(Employees.PARTITION_KEY);
            if (isbn != null && !isbn.isEmpty()) {
                Employees deletedBook = employeeTable.deleteItem(Key.builder().partitionValue(isbn).build());
                try {
                    responseBody = new ObjectMapper().writeValueAsString(deletedBook);
                } catch (JsonProcessingException e) {
                    context.getLogger().log("Failed create a JSON response: " + e);
                }
            }
        }
        return new APIGatewayProxyResponseEvent().withStatusCode(200)
                .withIsBase64Encoded(Boolean.FALSE)
                .withHeaders(Collections.emptyMap())
                .withBody(responseBody);
    }

}

