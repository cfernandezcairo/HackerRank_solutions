import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class QHeap {

    private List<Integer> heap;
    TreeSet<Integer> heap1;

    QHeap() {
        heap = new LinkedList<>();
        heap1 = new TreeSet<Integer>();
    }
    void add(Integer v) {
        heap.add(v);
        heap.sort(Comparator.naturalOrder());
    }

    void add1(Integer v) {
        Integer ins = v;

        for(int i = 0; i < heap.size(); i++) {
            Integer c = heap.get(i);
            if(c > ins) {
                heap.set(i, ins);
                ins = c;
            }
        }
        heap.add(ins);
    }

    void add2(Integer v) {
        heap1.add(v);
    }

    void delete(Integer v) {
        heap.remove(v);
    }

    void delete2(Integer v) {
        heap1.remove(v);
    }

    void printM(BufferedWriter bufferedWriter) throws IOException {
        if(!heap.isEmpty()) {
            bufferedWriter.write(String.valueOf(heap.get(0)));
            bufferedWriter.newLine();
        }
    }

    void printM2(BufferedWriter bufferedWriter) throws IOException {
        if(!heap1.isEmpty()) {
            bufferedWriter.write(String.valueOf(heap1.first()));
            bufferedWriter.newLine();
        }
    }
}

public class Solution_QHeap1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        QHeap qHeap = new QHeap();

        IntStream.range(0, q).forEach(tItr -> {
            try {
                String[] currentQuery = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int command = Integer.parseInt(currentQuery[0]);
                int commandParameter = 0;
                if(command != 3)
                    commandParameter = Integer.parseInt(currentQuery[1]);

                switch (command) {
                    case 1:
                        qHeap.add2(commandParameter);
                    break;
                    case 2:
                        qHeap.delete2(commandParameter);
                    break;
                    case 3:
                        qHeap.printM2(bufferedWriter);
                    break;
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}