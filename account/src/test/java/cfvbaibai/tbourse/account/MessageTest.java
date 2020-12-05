package cfvbaibai.tbourse.account;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class MessageTest extends TbourseWebTest {
    private static Logger log = LoggerFactory.getLogger(MessageTest.class);
    private static final String CF_CONTENT = "c";

    @Value("${hbase.tables.user_msg}")
    private String tableName;

    @Autowired
    private Configuration hbaseConfiguration;

    private static byte[] buildRowKey(int userId, LocalDateTime utc) {
        long epoch = utc.toEpochSecond(ZoneOffset.UTC);
        ByteBuffer buffer = ByteBuffer.allocate(12);
        buffer.putInt(0, userId);
        buffer.putLong(4, epoch);
        return buffer.array();
    }

    @Test
    public void testPing() {
        log.info("Message test!");
    }

    // @Test
    public void testMessageBasic() throws IOException {
        byte[] rowKey = buildRowKey(1, LocalDateTime.now(ZoneId.of("UTC")));
        String expectedValue = "Hellow World!";
        try (Connection connection = ConnectionFactory.createConnection(hbaseConfiguration)) {
            try (Table table = connection.getTable(TableName.valueOf(tableName))) {
                Put put = new Put(rowKey);
                put.addColumn(Bytes.toBytes("c"), Bytes.toBytes("content"), Bytes.toBytes(expectedValue));
                table.put(put);

                Get get = new Get(rowKey);
                Result result = table.get(get);
                log.info("Result = {}", result);
                byte[] bytes = result.getValue(Bytes.toBytes("c"), Bytes.toBytes("content"));
                String actualValue = Bytes.toString(bytes);
                assertEquals(expectedValue, actualValue);
            }
        }
    }
}
