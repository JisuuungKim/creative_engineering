
#define PIN_LED 7

int sum = 0;

void setup() {

  pinMode(PIN_LED, OUTPUT);

}


void loop() {
  digitalWrite(PIN_LED,0);
  delay(1000);
  while(sum<6) {
    digitalWrite(PIN_LED,0);
    delay(100);
    digitalWrite(PIN_LED,1);
    delay(100);
    sum +=1;
  }
  
  
  while(1) {
  digitalWrite(PIN_LED,1);
  }

 
}
