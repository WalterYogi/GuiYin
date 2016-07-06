package com.finance.brid.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2016/7/5.
 */
public class Base implements Serializable{


    /**
     * next_pull_time : 1499244005
     * servers : [{"mod":"resume","host":"192.168.0.114","schema":"http","port":8081,"version":"v1"}]
     */

    private int next_pull_time;
    /**
     * mod : resume
     * host : 192.168.0.114
     * schema : http
     * port : 8081
     * version : v1
     */

    private List<ServersEntity> servers;

    public int getNext_pull_time() {
        return next_pull_time;
    }

    public void setNext_pull_time(int next_pull_time) {
        this.next_pull_time = next_pull_time;
    }

    public List<ServersEntity> getServers() {
        return servers;
    }

    public void setServers(List<ServersEntity> servers) {
        this.servers = servers;
    }

    public static class ServersEntity implements Serializable{
        private String mod;
        private String host;
        private String schema;
        private int port;
        private String version;

        public String getMod() {
            return mod;
        }

        public void setMod(String mod) {
            this.mod = mod;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getSchema() {
            return schema;
        }

        public void setSchema(String schema) {
            this.schema = schema;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }
    }
}
