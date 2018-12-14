public class Fraction {
    private int num;
    private int denom;

    public Fraction(int num, int denom){
        if(denom == 0){
            throw new IllegalArgumentException("Denominator can not be zero!");
        }
        if(denom < 0){
            denom = Math.abs(denom);
            num = -num;
        }
        this.num = num;
        this.denom = denom;
    }

    public Fraction(int number){
        this.num = number;
        this.denom = 1;
    }

    public Fraction(){
        this.num = 0;
        this.denom = 1;
    }

    public int getNumerator(){
        return this.num;
    }

    public int getDenominator(){
        return this.denom;
    }

    public String toString(){
        return this.num + "/" + this.denom;
    }

    public double toDouble(){
        return this.num / this.denom;
    }

    public Fraction add(Fraction other){
        int new_other_num = other.getNumerator() * this.denom;
        int new_other_denom = other.getDenominator() * this.denom;

        int new_this_num = this.num * other.getDenominator();
        int new_this_denom = this.denom * other.getDenominator();

        Fraction result = new Fraction(new_other_num + new_this_num, new_this_denom);

        return result;
    }

    public Fraction subtract(Fraction other){
        int new_other_num = other.getNumerator() * this.denom;
        int new_other_denom = other.getDenominator() * this.denom;

        int new_this_num = this.num * other.getDenominator();
        int new_this_denom = this.denom * other.getDenominator();

        Fraction result = new Fraction(new_this_num - new_other_num, new_this_denom);

        return result;
    }

    public Fraction multiply(Fraction other){
        Fraction result = new Fraction(this.num * other.getNumerator(), this.denom * other.getDenominator());
        return result;
    }

    public Fraction divide(Fraction other){
        Fraction new_other = new Fraction(other.getDenominator(), other.getNumerator());
        return multiply(new_other);
    }

    public boolean equals(Fraction other){
        return this.toDouble() == other.toDouble();
    }

    public static int gcd(int num, int denom){
        while(num != 0 && denom != 0){
            int remainder = num % denom;
            num = denom;
            denom = remainder;
        }

        return num;
    }

    public void toLowestTerms() {
        int gcd = Fraction.gcd(this.num, this.denom);

        this.num /= gcd;
        this.denom /= gcd;
    }
}
