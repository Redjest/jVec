import java.util.ArrayList;
import java.util.Iterator;


public class VectorOperations {
    double eps = Double.MIN_NORMAL;

    double sum(double[] vec){
        double sum = 0;
        for(double element:vec){
            sum += element;
        }
        return sum;
    }

    int sum(int[] vec){
        int sum = 0;
        for(double element:vec){
            sum += element;
        }
        return sum;
    }

    double[] square(double[] vec){
        double [] res = new double[vec.length];
        int i = 0;
        for(double num:vec){
            res[i] = num * num;
            i++;
        }
        return res;
    }

    protected double[] plus(double[] vec1, double[] vec2){
        int len = vec1.length;
        double[] res = new double[len];
        for(int i=0;i<len;i++){
            res[i] = vec1[i] + vec2[i];
        }
        return res;
    }

    double[] mul(double[] vec1, double[] vec2){
        int len = vec1.length;
        double[] res = new double[len];
        for(int i=0;i<len;i++){
            res[i] = vec1[i]*vec2[i];
        }
        return res;
    }

    double[] minus(double[] vec1, double[] vec2){
        int len = vec1.length;
        double [] res = new double[len];
        for(int i=0;i<len;i++) {
            res[i] = vec1[i] - vec2[i];
        }
        return res;
    }

    protected double[] abs(double[] vec){
        double [] res = new double[vec.length];
        for (int i = 0; i < vec.length; i++) {
            res[i] = Math.abs(vec[i]);
        }
        return res;
    }

    double mean(double[] vec){
        return sum(vec)/vec.length;
    }

    double mean(int[] vec){
        return ((double) sum(vec)) / ((double) vec.length);
    }

    double[] scalar_mul(double scalar, double[] vec){
        double[] res = new double[vec.length];
        for(int i=0; i<vec.length; i++){
            res[i] = scalar*vec[i];
        }
        return res;
    }

    double[] ones(int length){
        double[] vec = new double[length];
        for(int i=0;i<length;i++){
            vec[i] = 1;
        }
        return vec;
    }

    double[] diff(double[] vec){
        double[] res = new double[vec.length-1];
        for(int i=0; i<res.length; i++){
            res[i] = vec[i+1]-vec[i];
        }
        return res;
    }

    int[] diff(int[] vec){
        int[] res = new int[vec.length-1];
        for(int i=0; i<res.length; i++){
            res[i] = vec[i+1]-vec[i];
        }
        return res;
    }

    double variance(double[] vec){
        int N = vec.length;
        double[] mu_vec = scalar_mul(mean(vec),ones(N));
        return sum(square(minus(vec,mu_vec)))/(N-1);
    }

    double coVariance(double[] x, double[] y){
        int N = x.length;
        double[] muX = scalar_mul(mean(x),ones(N));
        double[] muY = scalar_mul(mean(y),ones(N));
        return sum(mul(minus(x,muX),minus(y,muY)))/(N-1);
    }

    double std(double[] vec){
        return Math.sqrt(variance(vec));
    }

    double[] cos(double[] vec){
        double [] res = new double[vec.length];
        int i = 0;
        for(double num:vec){
            res[i] = Math.cos(num);
            i++;
        }
        return res;
    }

    double[] sin(double[] vec){
        double [] res = new double[vec.length];
        int i = 0;
        for(double num:vec){
            res[i] = Math.sin(num);
            i++;
        }
        return res;
    }

    double[] cumsum(double[] vec){
        double [] res = new double[vec.length];
        int i = 0;
        double sum = 0;
        for(double num:vec){
            sum += num;
            res[i] = sum;
            i++;
        }
        return res;
    }

    double[] range(double start, double step, double end){
        int length = (int) Math.floor((end-start)/step + 1);
        if(length < 1){
            return new double[0];
        }
        double[] res = new double[length];
        double current = start;
        int i = 0;
        while (current <= end){
            res[i] = current;
            current += step;
            i++;
        }
        return res;
    }

    double trapez(double[] x, double[] y){
        int length = x.length;
        double I = 0;
        for (int i=1; i<length; i++){
            I += (x[i] - x[i-1])*(y[i] + y[i-1]);
            if (i==174){
                double test = I;
            }
            if (i==175){
                double test = I;
            }
        }
        return I/2;
    }

    double linearRegressionSlope(double[] x, double[] y){
        double varX = variance(x);
        if(varX==0){
            varX += eps;
        }
        return coVariance(x,y)/varX;
    }

    double[] log10(double[] vec){
        double [] res = new double[vec.length];
        int i = 0;
        for(double num:vec){
            res[i] = Math.log10(num);
            i++;
        }
        return res;
    }

    int[] find(double[] vec, double scalarToFind){
        ArrayList<Integer> resList = new ArrayList<>();
        for(int i=0;i<vec.length;i++) if (vec[i] == scalarToFind) resList.add(i);
        int[] resArr = new int[resList.size()];
        Iterator<Integer> iterator = resList.iterator();
        for(int i=0;i<resList.size();i++) resArr[i] = iterator.next();
        return resArr;
    }

    double[] greaterThen(double[] vec, double scalar){
        double[] res = new double[vec.length];
        for(int i=0;i<vec.length;i++){
            if (vec[i]>scalar){
                res[i] = 1;
            }
            else {
                res[i] = 0;
            }
        }
        return res;
    }

    double[] lessThen(double[] vec, double scalar){
        double[] res = new double[vec.length];
        for(int i=0;i<vec.length;i++){
            if (vec[i]<scalar){
                res[i] = 1;
            }
            else {
                res[i] = 0;
            }
        }
        return res;
    }

    double[] list2vec(ArrayList<Double> list){
        double[] vec = new double[list.size()];
        Iterator<Double> iterator = list.iterator();
        for(int i=0; i<list.size();i++) vec[i] = iterator.next();
        return vec;
    }

    int[] list2vecInt(ArrayList<Integer> list){
        int[] vec = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        for(int i=0; i<list.size();i++) vec[i] = iterator.next();
        return vec;
    }

    double linearInterpolation(double x1, double y1, double x2, double y2, double x){
        return y1 + (x-x1)*(y2-y1)/(x2-x1);
    }
}
