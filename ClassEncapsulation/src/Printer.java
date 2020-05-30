public class Printer {
    private int blankPapers;
    private int printedPages;
    private int toner;
    private Boolean duplex;

    public Printer(int blankPapers, Boolean duplex) {
        this.blankPapers = blankPapers;
        this.toner = 50;
        this.duplex = duplex;
        this.printedPages = 0;
    }

    public void addBlankPages(int blankPapers) {
        this.blankPapers = blankPapers;
        System.out.println("Printer currently has " + blankPapers + " blank pages.");
    }

    public void addToner(int tonerRefill) {
        if (tonerRefill<0) {
            System.out.println("Toner refill must be a positive value. Printer toner remains at "+toner+"%.");
            return;
        }
        if (this.toner + tonerRefill > 100) {
            this.toner = 100;
        } else {
            this.toner += tonerRefill;
        }
        System.out.println("Current toner level: " + toner + "%.");
    }

    public int printPages(int numberOfPages) {
        int papersUsed, pagesPrinted;
        if (!!duplex) {
            //papersUsed = (int) Math.ceil((double) numberOfPages / 2);
            papersUsed = (numberOfPages/2)+(numberOfPages%2);
        } else {
            papersUsed = numberOfPages;
        }
        if (blankPapers - papersUsed > -1) {
            pagesPrinted = numberOfPages;
        } else {
            pagesPrinted = !!duplex
                    ? blankPapers * 2
                    : blankPapers;
        }
        blankPapers -= papersUsed;
        printedPages += pagesPrinted;
        String isPrinterDuplex = !!duplex ? "" : "not ";

        System.out.println("This is " + isPrinterDuplex + "a Duplex printer, so there are "
                + blankPapers + " papers left after printing " + pagesPrinted + " pages.");

        int pageDifference = (numberOfPages - pagesPrinted);
        if (pageDifference > 0) System.out.println(pageDifference + " pages were not printed, please add more paper.");
        return pagesPrinted;
    }

}
