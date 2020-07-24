*/
Printing a document, pricing goes like this:
From page 1 - 100 : 1 sided print is 250 dong/page ; 2 sided print is 300 dong/page
From page 100 onwards: 1 sided print is 220 dong/page ; 2 sided print is 280 dong/page

Written in IntelliJ IDEA - Time to complete : ~30 min
*/


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        class Document {
            int page;
            int doublePage;

            Document (int page) {
                this.page = page;
            }

            void pageSetup() {
                if(page % 2 == 0) {
                    doublePage = this.page / 2;
                }
                else {
                    doublePage = (this.page - 1) / 2;
                }
            }
        }

        System.out.print("Input page amount: ");
        Scanner readInput = new Scanner(System.in);
        int n = readInput.nextInt();

        int printPrice = 0;

        Document doc1 = new Document(n);

        if(doc1.page <= 100) {
            if(doc1.page % 2 == 0) {
                doc1.pageSetup();
                printPrice = doc1.doublePage * 300;
            }
            else {
                doc1.pageSetup();
                printPrice = doc1.doublePage * 300 + 250;
            }
        }
        else {
            if(doc1.page % 2 == 0) {
                doc1.pageSetup();
                if(doc1.doublePage <= 100) {
                    printPrice = doc1.doublePage * 300;
                }
                else {
                    printPrice = (100 * 300) + ((doc1.doublePage - 100) * 300);
                }
            }
            else {
                doc1.pageSetup();
                if(doc1.doublePage < 100) {
                    printPrice = doc1.doublePage * 300 + 250;
                }
                else if(doc1.doublePage == 100) {
                    printPrice = doc1.doublePage * 300 + 220;
                }
                else {
                    printPrice = (100 * 300) + ((doc1.doublePage) - 100) * 300 + 220;
                }
            }
        }

        System.out.println("Price to print document is: " + printPrice);
    }
}
