/**
* Programet beräknar och presenterar en tabell om batteriladdningstider
*
* 1. Variablerna och konstanterna deklareras först
* 2. Följt av uträkningarna på de olika nivåerna
* 3. De extra decimalerna tas sedan bort 
* 4. Resultaten printas sedan i en tabell
*
* @author Olivia Fabreschi, olifab-1@student.ltu.se */
  
  class Main
{
  public static void main(String[] args) 
    {
    
       //deklarera variablerna
      
        double BATTERY = 35.8; //kWh
        int STROM10 = 10;
        int STROM16= 16;
        int STROM32= 32; 
        int SPANNING230 = 230;
        int SPANNING400 = 400;

      //räkna ut laddeffekterna
      
        double laddeffekt1 = STROM10 * SPANNING230 /1000;
        double laddeffekt2 = STROM16 * SPANNING230 /1000;
        double laddeffekt3 = STROM10 * SPANNING400 * Math.sqrt(3)/1000;
        double laddeffekt4 = STROM16 * SPANNING400 * Math.sqrt(3)/1000;
        double laddeffekt5 = STROM32 * SPANNING400 * Math.sqrt(3)/1000;

      //räkna ut laddningstiden 
      
        double laddningstid1 = BATTERY / laddeffekt1;
        double laddningstid2 = BATTERY / laddeffekt2;
        double laddningstid3 = BATTERY / laddeffekt3;
        double laddningstid4 = BATTERY / laddeffekt4;
        double laddningstid5 = BATTERY / laddeffekt5;



      //tar bort decimalerna på ladeffekten och laddningstiden 

      //variablerna för decimalborttagning uträkning
        int noOfDecimals = 2;
        double scale = 0;
        scale = Math.pow(10, noOfDecimals); 
      
      //tar bort decimalerna på ladeffekten uträkningen
        double valueladd1 = laddeffekt1;
        double laddeffekt1New = 0;
        laddeffekt1New = Math.round(valueladd1 * scale) / scale;

        double valueladd2 = laddeffekt2;
        double laddeffekt2New = 0;
        laddeffekt2New = Math.round(valueladd2 * scale) / scale;

        double valueladd3 = laddeffekt3;
        double laddeffekt3New = 0;
        laddeffekt3New = Math.round(valueladd3 * scale) / scale;

        double valueladd4 = laddeffekt4;
        double laddeffekt4New = 0;
        laddeffekt4New = Math.round(valueladd4 * scale) / scale;

        double valueladd5 = laddeffekt5;
        double laddeffekt5New = 0;
        laddeffekt5New = Math.round(valueladd5 * scale) / scale;
      
      //tar bort decimalerna på laddningstiden uträkningen
        double value1 = laddningstid1;
        double laddningstid1New = 0;
        laddningstid1New = Math.round(value1 * scale) / scale;

        double value2 = laddningstid2;
        double laddningstid2New = 0;
        laddningstid2New = Math.round(value2 * scale) / scale;

        double value3 = laddningstid3;
        double laddningstid3New = 0;
        laddningstid3New = Math.round(value3 * scale) / scale;

        double value4 = laddningstid4;
        double laddningstid4New = 0;
        laddningstid4New = Math.round(value4 * scale) / scale;

        double value5 = laddningstid5;
        double laddningstid5New = 0;
        laddningstid5New = Math.round(value5 * scale) / scale;


        //resultaten som printas ut i tabellform
        System.out.print("\nBatteri 35.8 (kWh)\n\n");
        System.out.print("Ström(A)\t Spänning(V)\t Laddeffekt(kW)\t Laddningstid(h)\n");
        System.out.print("_____________________________________________________________\n");
        System.out.print("_____________________________________________________________\n");
        System.out.print(STROM10+"\t\t\t\t"+SPANNING230+"\t\t\t\t"+laddeffekt1New+"\t\t\t\t"+laddningstid1New+"\n");
        System.out.print(STROM16+"\t\t\t\t"+SPANNING230+"\t\t\t\t"+laddeffekt2New+"\t\t\t\t"+laddningstid2New+"\n");
        System.out.print(STROM10+"\t\t\t\t"+SPANNING400+"\t\t\t\t"+laddeffekt3New+"\t\t\t"+laddningstid3New+"\n");
        System.out.print(STROM16+"\t\t\t\t"+SPANNING400+"\t\t\t\t"+laddeffekt4New+"\t\t\t"+laddningstid4New+"\n");
        System.out.print(STROM32+"\t\t\t\t"+SPANNING400+"\t\t\t\t"+laddeffekt5New+"\t\t\t"+laddningstid5New+"\n");  
    }
   
}