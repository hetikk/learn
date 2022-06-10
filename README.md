## Step-by-step instructions for starting the project

<br>

#### 1. Start the project

Run command `make env-start`

<br>

#### 2.1. Elasticsearch

---

Run the command `make elasticsearch-disable-security` to disable elasticsearch security  
and restart elasticsearch `make elasticsearch-restart` to apply the settings

<br>

If everything is fine, then by clicking on the link http://localhost:9200/  
you should receive a message:
```json
{
  "name" : "a47460b34187",
  "cluster_name" : "docker-cluster",
  "cluster_uuid" : "o0PRpnIlS6CZc0EDTfbDIA",
  "version" : {
    "number" : "8.2.0",
    "build_flavor" : "default",
    "build_type" : "docker",
    "build_hash" : "b174af62e8dd9f4ac4d25875e9381ffe2b9282c5",
    "build_date" : "2022-04-20T10:35:10.180408517Z",
    "build_snapshot" : false,
    "lucene_version" : "9.1.0",
    "minimum_wire_compatibility_version" : "7.17.0",
    "minimum_index_compatibility_version" : "7.0.0"
  },
  "tagline" : "You Know, for Search"
}
```

<br>

#### 2.2. Logstash

---

Run the command `make logstash-disable-es-monitoring` to disable monitoring  
and `make logstash-restart` to restart elasticsearch to apply the settings

<br>

#### 2.3. Nginx

---

Open http://localhost/  
You should receive a message
```text
Hello, ELK!
```

<br>

#### 2.4. Kibana

---

Open http://localhost:5601  

