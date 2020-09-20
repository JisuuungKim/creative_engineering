
#define PIN_LED 7

unsigned int count, toggle;
int sum = 0;

void setup() {

  pinMode(PIN_LED, OUTPUT)

  ; Serial.begin(115200); // Initialize serial port

  while (!Serial) {

    ; // wait for serial port to connect.

  }

  Serial.println("Hello World!");

  count = toggle = 0;

  digitalWrite(PIN_LED, toggle); // turn off LED.

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
