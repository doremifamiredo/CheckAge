public class AgeControl {
    public boolean is18(int age) {
        return age >= 18;
    }

    public int insurance(int experience) {
        switch (experience) {
            case 0 : return 1000;
            case 1 :
            case 2 : return 800;
            case 3 :
            case 4 : return 600;
            case 5 :
            case 6 :
            case 7 :
            case 8 :
            case 9 : return 500;
            default : return 300;
        }
    }
}
