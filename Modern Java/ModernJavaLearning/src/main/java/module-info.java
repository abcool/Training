module modernJava{
    requires com.fasterxml.jackson.datatype.jsr310;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;

    exports edu.learning.checkoutApplication;
    exports edu.learning.http;
}