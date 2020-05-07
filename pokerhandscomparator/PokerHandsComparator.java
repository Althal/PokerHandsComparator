
package pokerhandscomparator;

import java.io.IOException;
import java.util.Arrays;
import pokerhandscomparator.cards.card.Card;
import pokerhandscomparator.cards.deck.Deck;
import pokerhandscomparator.cards.hand.Hand;
import pokerhandscomparator.cards.hand.HandStrength;
import java.util.Scanner;

public class PokerHandsComparator {

    
    public static void main(String... args) throws IOException{
        String readString = null; 
        do {
            System.out.flush();
            System.out.println("Tasowanie...");
            System.out.println(); 
            Deck d = new Deck();
            
            System.out.println("Wylosowano karty dla GRACZA 1:");
            Hand hand1 = new Hand();
            hand1.setHandCards(new Card[]{d.takeCard(), d.takeCard()});            
            System.out.print(hand1.getHandCards()[0]); System.out.print(" "); System.out.print(hand1.getHandCards()[1]);
            System.out.println();System.out.println(); 
            
            System.out.println("Wylosowano karty dla GRACZA 2:");
            Hand hand2 = new Hand();
            hand2.setHandCards(new Card[]{d.takeCard(), d.takeCard()});                                
            System.out.print(hand2.getHandCards()[0]); System.out.print(" "); System.out.print(hand2.getHandCards()[1]);
            System.out.println();System.out.println(); 
            
            System.out.println("Wylosowano karty na STÓŁ:");
            Card[] table = new Card[]{d.takeCard(), d.takeCard(), d.takeCard(), d.takeCard(), d.takeCard()};
            hand1.setTableCards(table);
            hand2.setTableCards(table); 
            System.out.print(table[0]); System.out.print(" "); 
            System.out.print(table[1]);System.out.print(" "); 
            System.out.print(table[2]);System.out.print(" "); 
            System.out.print(table[3]);System.out.print(" "); 
            System.out.print(table[4]);System.out.println();System.out.println(); 
            

            
            Card[] cards1 = HandStrength.getBestHand(hand1);
            int str1 = HandStrength.getCombinationStrength(cards1);
            System.out.println("Gracz 1 ma:");
            System.out.println(HandStrength.getHandName(str1) + " " + Arrays.toString(cards1));
            System.out.println();
            
            Card[] cards2 = HandStrength.getBestHand(hand2);
            int str2 = HandStrength.getCombinationStrength(cards2);
            System.out.println("Gracz 2 ma:");
            System.out.println(HandStrength.getHandName(str2) + " " + Arrays.toString(cards2));
            System.out.println();
            
            System.out.println("Wygrywa gracz: " + (str1 == str2? "REMIS": (str1 > str2? "1" : "2")));
            System.out.println(); 
            
            
            System.out.println("Koniec gry. Wpis 'exit' aby zakończyć lub co innego, aby ponowić.");
            
            Scanner scanner = new Scanner(System.in);
            readString = scanner.nextLine();
            
        } while(!"exit".equals(readString));
    }
}
