package lambda;
import model.Employees;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.DependencyFactory;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.Collections;
public class UpdateItemFunction implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private final DynamoDbEnhancedClient dbClient;
    private final String tableName;
    private final TableSchema<Employees> employeeTableSchema;

    public UpdateItemFunction() {
        dbClient = DependencyFactory.dynamoDbEnhancedClient();
        tableName = DependencyFactory.tableName();
        employeeTableSchema = TableSchema.fromBean(Employees.class);
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        String body = request.getBody();
        String responseBody = "";
        if (body != null && !body.isEmpty()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Employees item;
            try {
                item = objectMapper.readValue(body, Employees.class);
                if (item != null) {
                    DynamoDbTable<Employees> booksTable = dbClient.table(tableName, employeeTableSchema);
                    Employees updateResult = booksTable.updateItem(item);
                    responseBody = objectMapper.writeValueAsString(updateResult);
                }
            } catch (JsonProcessingException e) {
                context.getLogger().log("Failed to process JSON: " + e);
            }
        }
        return new APIGatewayProxyResponseEvent().withStatusCode(200)
                .withIsBase64Encoded(Boolean.FALSE)
                .withHeaders(Collections.emptyMap())
                .withBody(responseBody);
    }
}

