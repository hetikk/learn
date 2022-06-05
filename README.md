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

