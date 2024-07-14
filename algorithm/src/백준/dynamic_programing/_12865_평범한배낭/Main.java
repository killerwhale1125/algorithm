package 백준.dynamic_programing._12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 배낭문제
 * 거꾸로 메모제이션.
 * 스트림은 연습용. 실제 병렬프로그래밍에서 아래같이 dp같은 자유변수 사용 금지
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Product> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Product product = new Product(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            list.add(product);
        }

        int[] dp = new int[K+1];
        list.sort(Comparator.comparing(Product::getWeight)
                .thenComparing(Product::getPrice));

        list.forEach(product -> IntStream.iterate(K, i -> i >= product.weight, i -> --i)
                        .forEach(i -> dp[i] = Math.max(dp[i], dp[i - product.weight] + product.price)));

        System.out.println(dp[K]);
    }

    static class Product {
        int weight;
        int price;

        public Product(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        public int getWeight() {
            return weight;
        }

        public int getPrice() {
            return price;
        }
    }
}
