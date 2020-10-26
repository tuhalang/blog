var inp = "# Xây dựng ứng dụng realtime theo dõi nhiệt độ, độ ẩm, ánh sáng sử dụng Firebase Phần I\n" +
    "Đây là bài viết khởi đầu cho chuỗi bài viết về dự án: *xây dựng ứng dụng theo dõi nhiệt độ, độ ẩm, ánh sáng sử dụng Firebase*\n" +
    "Cách tạo project và kết nối Firebase và Arduino tôi đã viết trong bài viết: \n" +
    "[Link](), các bạn có thể tham khảo.\n" +
    "\n" +
    ">Let's go\n" +
    "## I. Giới thiệu dự án\n" +
    "Dự án này gồm 2 phần chính:\n" +
    "\n" +
    "Ứng dụng trên Android dùng để đọc dữ liệu nhiệt độ, độ ẩm, ánh sáng trên Firebase, cũng như điều khiển  thiết bị qua Firebase (thay đổi trạng thái dữ liệu trên firebase, và firebase tự cập nhật về Arduino).\n" +
    "Nhiều module ESP8266 để đọc dữ liệu của nhiều vị trí khác nhau. Vị trí của module được cấu hình tĩnh trong code bằng tọa độ GPS.\n" +
    "Cụ thể trong dự án này tôi dùng Wemos D1.\n" +
    "\t \n" +
    "\n" +
    "### Mục tiêu\n" +
    "\n" +
    "- Xây dựng và phát triển hệ thống thu thập dữ liệu thời gian thực gồm nhiều module thu thập thông tin độc lập. Những thông tin này gồm có nhiệt độ, độ ẩm, ánh sáng được đồng bộ thời gian thực lên cloud, cụ thể là firebase.\n" +
    "\n" +
    "- Xây dựng ứng dụng di động có khả năng theo dõi và điều khiển các module từ xa thông qua cloud.\n" +
    "## II. Các linh kiện, thiết bị cần thiết.\n" +
    "\n" +
    "- Wemos D1 (sử dụng ESP8266) : có bán nhiều ở các cửa hàng linh kiện dành cho sinh viên.\n" +
    "- DHT11: giá khoảng 50k (theo kinh nghiệm cá nhân thì là dễ hỏng, các bạn mua nên cẩn thận). Có điều kiện kinh tế hơn thì dùng DHT22 ^.^\n" +
    "\n" +
    "![dht11](https://i.ibb.co/L5w03M8/DHT11.jpg)\n" +
    "- Cảm biến ánh sáng: con cảm biến này rẻ, 3-5k, mình không rõ tên.\n" +
    "- Hai đèn led 3.3-5V.\n" +
    "- Điện thoại sử dụng hệ điều hành Android ^.^.\n" +
    "## III. Sơ đồ nguyên lí và lắp mạch.\n" +
    "\n" +
    "Trong proteus tôi không có thư viện wemos d1 nên t dùng Arduino Uno R3 để mô phỏng. Đây là sơ đồ nguyên lí mạch. Rất đơn giản như sau:\n" +
    "\n" +
    "![so-do-nguye-li](https://i.ibb.co/nwbXB5P/so-do-nguyen-li-wemos-d1.png)\n" +
    "\n" +
    "> Sơ đồ rất đơn giản nên các bạn có thể tự lắp mạch thật cho mình. Chân 2 của uno là chân D9 của wemos (cũng có thể tùy thuộc nhà sản xuất mà các bạn tùy biến cho phù hợp).\n" +
    "Đây là một module mà mình làm:\n" +
    "\n" +
    "  ![module-project-ii](https://i.ibb.co/m6n6gBY/module-wemos-d1.jpg)\n" +
    "\n" +
    "## IV. Cấu trúc lưu dữ liệu trên Realtime Database\n" +
    "Các bạn nếu đã làm việc với Firebase chắc cũng đã hiểu Realtime Database là gì. Dữ liệu trong Realtime Database sử dụng cấu trúc lưu trữ JSON. Các bạn muốn tìm hiểu thêm về Realtime DB của firebase có thể tham khảo tại [link](https://viblo.asia/p/lam-viec-voi-firebase-realtime-database-ZjlvalVXkqJ).\n" +
    "Dữ liệu gồm có 2 phần status và storage. \n" +
    "\n" +
    "- status dùng để lưu trữ trạng thái của 2 đèn led (dùng để điều khiển 2 đèn LED ứng với từng module), thời gian thu thập dữ liệu TIME_COLLECTION.\n" +
    "- storage dùng để lưu dữ liệu của các module gửi lên. Trong phần I sẽ dùng chủ yếu storage này.\n" +
    "![root-data](https://i.ibb.co/x3xZ52v/root-data.png)\n" +
    "![status-data](https://i.ibb.co/Wz92FYC/status-data.png)\n" +
    "![storage-data](https://i.ibb.co/z4Ch90S/storage-data.png) \n" +
    "\n" +
    "> Giải thích: trong storage và status có dữ liệu con là các module, id là vị trí của module đó (latitude và longitude nhân với 1000 cho dễ lưu trữ). Đối với status có 3 trường LED1 (điều khiển LED1), LED2 (điều khiển LED2), TIME_COLLECTION (thời gian thu thập dữ liệu).\n" +
    "> Đối với storage, trong mỗi module lưu trữ các dữ liệu lưu trữ tại từng thời điểm. Có các trường như trong hình vẽ. Có lẽ nó rất tường minh nên tôi có thể không cần giải thích.\n" +
    "\n" +
    "Như vậy, chúng ta đã giải quyết xong vấn đề lưu trữ dữ liệu trên Firebase. Tiếp theo, chúng ta sẽ bắt tay vào code cho phần Arduino.\n" +
    "\n" +
    "## V. Thư viện và chương trình.\n" +
    "Trong dự án Arduino này tôi có sử dụng các thư viện như sau:\n" +
    "\n" +
    "- DHT.h\n" +
    "- NTPClient.h\n" +
    "- ESP8266WiFi.h\n" +
    "- Firebase.h\n" +
    "- FirebaseCloudMessaging.h\n" +
    "- WifiLocation.h\n" +
    "Những thư viện này hầu hết đều có sẵn trong trình quản lí thư viện của Arduino IDE, các bạn có thể tự tải về. Với thư viện NTPClient các bạn có thể tải tại [https://github.com/arduino-libraries/NTPClient](https://github.com/arduino-libraries/NTPClient).<br>\n" +
    "Code:\n" +
    "```\n" +
    "\t    #include <Adafruit_Sensor.h>\n" +
    "        #include <DHT.h>    \n" +
    "        #include <WiFiUdp.h>\n" +
    "        #include <WifiLocation.h>\n" +
    "        #include <NTPClient.h>\n" +
    "        \n" +
    "        #include <ESP8266WiFi.h>\n" +
    "        \n" +
    "        #include <Firebase.h>\n" +
    "        #include <FirebaseArduino.h>\n" +
    "        #include <FirebaseCloudMessaging.h>\n" +
    "        #include <string.h>\n" +
    "        \n" +
    "        #define WIFI_SSID \"xxxxxxx\"\n" +
    "        #define WIFI_PASSWORD \"xxxxxxxx\"\n" +
    "        #define FIREBASE_HOST \"controlarduino-xxxxx.firebaseio.com\"\n" +
    "        #define FIREBASE_AUTH \"xxxxxxxxx\"\n" +
    "        #define R1 8200\n" +
    "        #define Vin 5\n" +
    "        #define LED_PIN1 12// là chân D6\n" +
    "        #define LED_PIN2 13// chân D7\n" +
    "        #define M 100000\n" +
    "        \n" +
    "         \n" +
    "        String pos=\"20114:106163\";\n" +
    "        const int quangtro=A0;\n" +
    "        const int DHTTYPE = DHT11;\n" +
    "        const int DHTPIN = 2; //chân D9\n" +
    "        unsigned long time_collection=900000;\n" +
    "        byte mac[6];\n" +
    "        unsigned long cycle1 = 0;\n" +
    "        unsigned long cycle2 = 0;\n" +
    "        WiFiUDP ntpUDP;\n" +
    "        NTPClient timeClient(ntpUDP);\n" +
    "        DHT dht(DHTPIN, DHTTYPE);\n" +
    "        \n" +
    "        void setup()\n" +
    "        {\n" +
    "          Serial.begin(9600);\n" +
    "          delay(2000);\n" +
    "          Serial.println('\\n');\n" +
    "          wifiConnect();\n" +
    "          timeClient.begin();\n" +
    "          timeClient.setTimeOffset(25200);\n" +
    "          Firebase.begin(FIREBASE_HOST, FIREBASE_AUTH);\n" +
    "          Firebase.stream(\"/status/\" + pos);\n" +
    "          pinMode(quangtro,INPUT);\n" +
    "          pinMode(LED_PIN1,OUTPUT);\n" +
    "          pinMode(LED_PIN2,OUTPUT);\n" +
    "          dht.begin();\n" +
    "          WiFi.macAddress(mac);\n" +
    "          delay(2000);\n" +
    "        }\n" +
    "        \n" +
    "        void loop()\n" +
    "        {  \n" +
    "          StaticJsonBuffer<200> jsonBuffer;\n" +
    "          JsonObject& root = jsonBuffer.createObject();\n" +
    "          /---------------------------------------------------------/\n" +
    "          unsigned long curr=(unsigned long)millis();\n" +
    "          if (curr - cycle1 > time_collection){\n" +
    "            timeClient.update();\n" +
    "            String formattedDate = timeClient.getFormattedDate();\n" +
    "            /----------------------------------------------------/\n" +
    "            float t = dht.readTemperature();\n" +
    "            float h = dht.readHumidity();\n" +
    "            float ADC=analogRead(quangtro);\n" +
    "        //    Serial.println(Vin);\n" +
    "        //    float Vout = ADC * (Vin / 1024.0);\n" +
    "        //    Serial.println(Vout);\n" +
    "        //    float RLDR = (R1 * (Vin - Vout))/Vout;\n" +
    "            if (isnan(t) || isnan(h)) {\n" +
    "                Serial.println(\"Failed to read from DHT sensor!\");\n" +
    "                if (isnan(t)) t = M;\n" +
    "                if (isnan(h)) h = M;\n" +
    "            }\n" +
    "            root[\"mac_add\"]=binToString(mac,6);\n" +
    "            root[\"temp\"]=t;\n" +
    "            root[\"lux\"]=ADC;\n" +
    "            root[\"humidity\"]=h;\n" +
    "            /*************************************/\n" +
    "            String jsonStr = \"\";\n" +
    "            root.printTo(jsonStr);\n" +
    "            String path=\"storage/\" + pos + \"/\" + formattedDate;\n" +
    "            Firebase.set(path, root);\n" +
    "            if (Firebase.success())\n" +
    "            {\n" +
    "              Serial.println(\"SET JSON --------------------\");\n" +
    "              Serial.println(\"PASSED\");\n" +
    "              Serial.println();\n" +
    "            }else {\n" +
    "              Serial.println(\"SET DATA FAILED\");\n" +
    "              Serial.println(\"------------------------------------\");\n" +
    "              Serial.println();\n" +
    "            }\n" +
    "            /***********************************/\n" +
    "            if (Firebase.failed()) {\n" +
    "              Serial.println(Firebase.error());\n" +
    "              Serial.print(\"fail!\");\n" +
    "            }\n" +
    "            cycle1 = curr;\n" +
    "          }// kết thúc chu kì gửi dữ liệu\n" +
    "          else if (curr-cycle2>51){\n" +
    "            if (Firebase.failed()) {\n" +
    "              Serial.println(\"streaming error\");\n" +
    "              Serial.println(Firebase.error());\n" +
    "              Firebase.stream(\"/status/\" + pos);\n" +
    "              return;\n" +
    "            }\n" +
    "            if (Firebase.available()) {\n" +
    "             FirebaseObject event = Firebase.readEvent();\n" +
    "             String eventType = event.getString(\"type\");\n" +
    "             if (eventType==\"put\"){\n" +
    "               Serial.print(\"data: \");\n" +
    "               String data=event.getString(\"data\");\n" +
    "               Serial.println(data);\n" +
    "               DynamicJsonBuffer jsonBuffer;\n" +
    "               JsonObject& r = jsonBuffer.parseObject(data);\n" +
    "               String path = r.get<String>(\"path\");\n" +
    "               if (path==\"/\"){\n" +
    "                JsonObject& conf=jsonBuffer.parseObject(r.get<String>(\"data\"));\n" +
    "                analogWrite(LED_PIN1,int(conf.get<float>(\"LED1\")));\n" +
    "                analogWrite(LED_PIN2,int(conf.get<float>(\"LED2\")));\n" +
    "                time_collection=conf.get<int>(\"TIME_COLLECTION\");\n" +
    "                time_collection=conf.get<int>(\"TIME_COLLECTION\");\n" +
    "               }else if (path==\"/LED1\"){\n" +
    "                analogWrite(LED_PIN1,int(r.get<float>(\"data\")));\n" +
    "               }else if (path==\"/LED2\"){\n" +
    "                analogWrite(LED_PIN2,int(r.get<float>(\"data\")));\n" +
    "               }else if (path==\"\"){\n" +
    "                time_collection=r.get<int>(\"data\");\n" +
    "               }\n" +
    "             }\n" +
    "            }\n" +
    "            cycle2 = curr;\n" +
    "          }\n" +
    "          if(WiFi.status() != WL_CONNECTED){\n" +
    "            wifiConnect();\n" +
    "          }\n" +
    "        }\n" +
    "        \n" +
    "        //-----------------------------------------end loop---------------------\n" +
    "        String binToString(byte *inputData, int dataLength) {\n" +
    "          char asciiString[dataLength*2 +1];   // 2 characters per byte plus a null at the end.\n" +
    "          for (int i = 0; i < dataLength; i++) {\n" +
    "            sprintf(asciiString+2*i,\"%02X\",*(inputData+i));\n" +
    "          }\n" +
    "          asciiString[dataLength*2] = 0; // in theory redundant, the last sprintf should have done this but just to be sure...\n" +
    "          return String(asciiString);\n" +
    "        }\n" +
    "        \n" +
    "        void wifiConnect()\n" +
    "        {\n" +
    "          WiFi.begin(WIFI_SSID, WIFI_PASSWORD);             // Connect to the network\n" +
    "          Serial.print(\"Connecting to \");\n" +
    "          Serial.print(WIFI_SSID); Serial.println(\" ...\");\n" +
    "          int teller = 0;\n" +
    "          while (WiFi.status() != WL_CONNECTED)\n" +
    "          {                                       // Wait for the Wi-Fi to connect\n" +
    "            delay(1000);\n" +
    "            Serial.print(++teller); Serial.print(' ');\n" +
    "          }\n" +
    "          Serial.println('\\n');\n" +
    "          Serial.println(\"Connection established!\");\n" +
    "          Serial.print(\"IP address:\\t\");\n" +
    "          Serial.println(WiFi.localIP());         // Send the IP address of the ESP8266 to the computer\n" +
    "        }\n" +
    "```\n" +
    "Các bạn thay mật khẩu wifi và firebase id, auth bằng wifi và project của mình nhé. Code này tôi có thể tham khảo ở một số nguồn, nếu các bạn có cách tốt hơn hoặc phát hiện ra lỗi, các bạn có thể góp ý cho tôi qua mail hoặc facebook.\n" +
    "## VI. Lời kết.\n" +
    "\n" +
    "*Lập trình với Arduino cũng rất thú vị. Nhưng điều quan trọng nhất vẫn là kiên trì fixbug.*\n" +
    "\n" +
    "Vậy là tôi đã hướng dẫn xong các bạn lập trình cho Arduino đọc dữ liệu và gửi lên Firebase, cũng như cấu trúc lưu dữ liệu trên Realtime DB.\n" +
    "Trong phần code đã có cả điều khiển LED, TIME_COLLECTION, tôi sẽ hướng dẫn ở phần sau.\n" +
    "Chúc các bạn thành công.\n" +
    "Kết quả project tôi đã làm.\n" +
    "\n" +
    "[link youtube](https://www.youtube.com/embed/wWUSbN1LrHA)"
var mdHtml = markdownit("commonmark")
document.getElementById("content-main").innerHTML = mdHtml.render(inp)