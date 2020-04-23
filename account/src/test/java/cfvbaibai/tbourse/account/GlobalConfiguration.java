package cfvbaibai.tbourse.account;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;


@org.springframework.context.annotation.Configuration
@SuppressWarnings("unused")
public class GlobalConfiguration {
    @Value("${hbase.zookeeper.address}")
    private String hbaseZookeeperAddress;

    @Bean
    public Configuration getHBaseConfiguration() {
        Configuration config = HBaseConfiguration.create();
        String zkAddress = "hb-proxy-pub-bp1n0q702l2cir025-001.hbase.rds.aliyuncs.com:2181";
        config.set(HConstants.ZOOKEEPER_QUORUM, zkAddress);
        return config;
    }
}
