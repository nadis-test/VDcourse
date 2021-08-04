class Aspirant extends Student{
    private String Essai;

    Aspirant(String FN, String LN, String Gr, String Es){
        super(FN, LN, Gr);
        Essai = Es;
    }

    @Override
    int getScholarship() {
        if (averageMark == 5) return 200;
        else return 180;
    }

    @Override
    public String toString()  {
        return super.toString() + " " + Essai;
    }
}



