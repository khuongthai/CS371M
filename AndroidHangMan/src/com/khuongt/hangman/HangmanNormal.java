package com.khuongt.hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class HangmanNormal {

	// Add your private member variables here
	private String originSecretWord = "";// To store the secret word
	private int guessRemainingNum;// to store the number of guess for the user
	private ArrayList<Character> secretChars;
	private ArrayList<Character> guessedChars;
	private ArrayList<Character> returnChars;

	/**
	 * Constructor sets up the game to be played with a word and some number of
	 * guesses. The class should have private variables that keep track of: <li>
	 * The original secret word <li>The number of guesses remaining <li>The
	 * number of letters that still need to be guessed <li>The current state of
	 * word to be guessed (e.g. "L A B _ R A _ _ R Y")
	 * 
	 * @param secretWord
	 *            the word that the player is trying to guess
	 * @param numGuesses
	 *            the number of guesses allowed
	 */
	public HangmanNormal(String secretWord, int numGuesses, String LetterHistory) {
		originSecretWord = secretWord;
		guessRemainingNum = numGuesses;
		secretChars = getLettersFromWord(secretWord, true);
		returnChars = getLettersFromWord(secretWord, false);
		guessedChars = new ArrayList<Character>();
	}

	// add your methods below
	public String getSecretWord() {
		return originSecretWord;
	}

	public int numGuessesRemaining() {
		return guessRemainingNum;
	}

	public boolean isWin() {
		if (guessRemainingNum == 0)
			return false;// if the user have no chance to guess again, it means
							// the user loses.
		else
			return true;
	}

	public boolean gameOver() {
		if (guessRemainingNum == 0 || !returnChars.contains('-'))
			return true;
		else
			return false;
	}

	public String lettersGuessed() {
		StringBuffer retVal = new StringBuffer();
		int size = guessedChars.size();
		for (int i=0; i<size;i++) {
			retVal.append(guessedChars.get(i));
			if (i != size-1) retVal.append(", ");
		}
		return retVal.toString();
	}

	public String displayGameState() {
		StringBuffer retVal = new StringBuffer();
		int size = returnChars.size();
		for (int i=0; i<size;i++) {
			retVal.append(returnChars.get(i));
		}
		return retVal.toString();
	}

	public int makeGuess(char ch) {
		if (guessedChars.contains(ch)) {	
			return -1;
		} else {
			guessedChars.add(ch);
			guessRemainingNum--;
			if (secretChars.contains(ch)) {
				int pos = secretChars.indexOf(ch);
				returnChars.add(pos, ch);
				returnChars.remove(pos+1);
				return 1;
			} else {
				return 0;
			}
		}		
	}


	private ArrayList<Character> getLettersFromWord(String secretWord,
			boolean word) {
		ArrayList<Character> retVal = new ArrayList<Character>();
		for (int i = 0; i < secretWord.length(); i++) {
			if (word) {
				retVal.add(secretWord.charAt(i));
			} else {
				retVal.add('-');
			}
		}
		return retVal;
	}

}