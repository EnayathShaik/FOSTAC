package com.ir.util;

import java.util.Random;

public class PasswordGenerator {
	
	// DATA
    // characters with which the password will be composed
    private  final int charactersSize = 52;
    private  char [] characters = new char [charactersSize];

    // keep the counts of used characters 7Mk5qaYsGS
    private static int charactersCount = 0;

    // size of the password to generate
    private int passwordSize;

  // CONSTRUCTOR 8Ic9oNKwR1
    public PasswordGenerator( int passwordSize ) {

      // set the password size
      this.passwordSize = passwordSize;

      // set the characters that will be used to generate the password
      initCharacters();
    }

  // METHODS
    // fill the array of characters that will be used to generate the password 
    private  char [] initCharacters() {
      int i = 0;

      for(char c='0';c<='9';c++){
    	  characters[i] = (char) c;
      }
      // add 0-9
    /*  for ( int j = 48; j < 58; ++i, ++j, ++charactersCount ) {
        characters[i] = (char) j;
      }*/

      // add @ + a-z
      for ( int j = 65; j < 91; ++i, ++j, ++charactersCount ) {
        characters[i] = (char) j;
      }

      // add A-Z
      for ( int j = 97; j < 123; ++i, ++j, ++charactersCount ) {
        characters[i] = (char) j;
      }

      return characters;
    }

    // generate a random password
    public char [] get() {

      // initialize the random number generator
      Random rnd = new Random();

      char [] password = new char [passwordSize];


      // choose a random character from the array
      for ( int i = 0; i < passwordSize; ++i ) {
    	int randomNumber = rnd.nextInt(charactersCount);
    	if(randomNumber > 52)
    	{
    		randomNumber = randomNumber%52;
    	}
        password[i] = characters[randomNumber ];
        System.out.println("password[i]" +password[i]);
      }
      return password;
    }

}
