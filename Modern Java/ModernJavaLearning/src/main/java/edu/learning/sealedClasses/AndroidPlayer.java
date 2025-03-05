package edu.learning.sealedClasses;

public sealed interface AndroidPlayer permits Truck{
    void runMusic();
}
