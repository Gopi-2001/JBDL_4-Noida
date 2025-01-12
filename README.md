# JBDL_4-Noida

Major Project:

User Creation Request:
curl --location 'http://localhost:8082/onboarding-service/onboard/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Lokesh",
    "email": "lokeshmangal70@gmail.com",
    "phoneNo": "9717763448",
    "password": "lokesh123",
    "userIdentifier": "AADHAAR",
    "userIdentifierValue": "894598235680",
    "dob": "21/09/1992",
    "address": "M.V Phase-1"
}'

Transaction Creation Request:
curl --location 'http://localhost:8083/transaction-service/initiate/transaction?amount=2&purpose=sample&receiver=9717763449' \
--header 'Authorization: Basic OTcxNzc2MzQ1Njpyb2JpbjEyMw=='
