public enum RimNum {
    I(1), II(2), III(3), IV(4), V(5),
    VI(6), VII(7), VIII(8), IX(9), X(10),
    XL(40), L(50), XC(90) ;
   /* XI(11, "XI"), XII(12, "XII"), XIII(13, "XIII"), XIV(14, "XIV"), XV(15, "XV"),
    XVI(16, "XVI"), XVII(17, "XVII"), XVIII(18, "XVIII"), XIX(19, "XIX"), XX(20, "XX")*/


    private int count;
    private RimNum(int count){
        this.count = count;
    }


    public int getCount(){
        return this.count;
    }
}
