package io.github.luochangcheng.cccloudmybatisplusrepository;

import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.google.common.collect.Lists;
import io.github.luochangcheng.cccloudcommoncore.enums.ClientType;
import io.github.luochangcheng.cccloudstartermybatisplus.utils.code.CodeGenerator;
import org.apache.commons.collections4.map.SingletonMap;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        SingletonMap<String, List<String>> repository = new SingletonMap<>("io.github.luochangcheng.cccloudmybatisplusrepository", Lists.newArrayList("cc-cloud-common", "cc-cloud-mybatis-plus-repository"));
        SingletonMap<String, List<String>> service = new SingletonMap<>("io.github.luochangcheng.ccclouduser", Lists.newArrayList("cc-cloud-module", "cc-cloud-user"));
        CodeGenerator.execute("jdbc:mysql://127.0.0.1:13306/cc_cloud_user?characterEncoding=UTF-8&allowMultiQueries=true&useSSL=true", "cc_cloud_user",
                "root", "root", new MySqlQuery(), new MySqlTypeConvert(), Lists.newArrayList("sys_admin_user"), repository, service, ClientType.APPLET);
    }

}
