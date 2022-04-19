package tests;

public class Calculation {

    public int getQuantityForProduct(int productType, int materialType, int count, float width, float length) {
        double d = 1;

        if (count < 0 || width <= 0 || length <= 0) {
            return -1;
        }
        d *= count;
        d *= width;
        d *= length;

        switch (productType) {
            case 1:
                d *= 1.1;
                break;
            case 2:
                d *= 2.5;
                break;
            case 3:
                d *= 8.43;
                break;
            default:
                return -1;
        }

        switch (materialType) {
            case 1:
                d /= 99.7;
                d *= 100;
                break;
            case 2:
                d /= 99.88;
                d *= 100;
                break;
            default:
                return -1;
        }

        return (int) Math.ceil(d);

    }

}
