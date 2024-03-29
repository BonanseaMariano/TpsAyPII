package fecha;

// Date class declaration.
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Date {

    private int month; // 1-12
    private int day;   // 1-31 based on month
    private int year;  // any year

    // constructor: call checkMonth to confirm proper value for month; 
    // call checkDay to confirm proper value for day
    public Date(int theMonth, int theDay, int theYear) {
        month = checkMonth(theMonth); // validate month
        year = theYear; // could validate year
        day = checkDay(theDay); // validate day

        System.out.printf(
                "Date object constructor for date %s\n", this);
    } // end Date constructor

    // utility method to confirm proper month value
    private int checkMonth(int testMonth) {
        if (testMonth > 0 && testMonth <= 12) // validate month
        {
            return testMonth;
        } else // month is invalid 
        {
            System.out.printf(
                    "Invalid month (%d) set to 1.", testMonth);
            return 1; // maintain object in consistent state
        } // end else
    } // end method checkMonth

    // utility method to confirm proper day value based on month and year
    private int checkDay(int testDay) {
        int daysPerMonth[]
                = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // check if day in range for month
        if (testDay > 0 && testDay <= daysPerMonth[month]) {
            return testDay;
        }

        // check for leap year
        if (month == 2 && testDay == 29 && (year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0))) {
            return testDay;
        }

        System.out.printf("Invalid day (%d) set to 1.", testDay);
        return 1;  // maintain object in consistent state
    } // end method checkDay

    // return a String of the form month/day/year
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    } // end method toString

    public void diaSiguiente() {
        int daysPerMonth[]
                = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (day == daysPerMonth[month]) {
            if (month == 12) {
                year++;
                month = 1;
            } else {
                month++;
            }
            day = 1;
        } else {
            day++;
        }

    }

    public void diaAnterior() {
        int daysPerMonth[]
                = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (day == 1) {
            if (month == 1) {
                year--;
                month = 12;
            } else {
                month--;
            }
            day = daysPerMonth[month];
        } else {
            day--;
        }
    }

    public void impresionCompararFechas(Date b) {
        int comparacion = compararFechas(b);
        if (comparacion == 0) {
            System.out.println("Ambas Fechas son iguales");
        } else if (comparacion < 0) {
            System.out.println("La fecha " + b.toString() + " es mayor");
        } else {
            System.out.println("La fecha " + b.toString() + " es menor");
        }
    }

    public void diasEntreFechas(Date b) {
        LocalDate fechaA = LocalDate.of(this.year, this.month, this.day);
        LocalDate fechaB = LocalDate.of(b.year, b.month, b.day);

        // Convertir meses y años a días
        long dias = ChronoUnit.DAYS.between(fechaA, fechaB);

        System.out.println("Hay " + dias + " dias de diferencia entre " + this.toString() + " y " + b.toString());
    }

    public int compararFechas(Date b) {
        if (!this.equals(b)) {
            if (this.year != b.year) {
                return this.year - b.year;
            } else {
                if (this.month != b.month) {
                    return this.month - b.month;
                } else {
                    return this.day - b.day;
                }
            }
        }
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Date other = (Date) obj;
        if (this.month != other.month) {
            return false;
        }
        if (this.day != other.day) {
            return false;
        }
        return this.year == other.year;
    }

} // end class Date

/**
 * ************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 * ***********************************************************************
 */
