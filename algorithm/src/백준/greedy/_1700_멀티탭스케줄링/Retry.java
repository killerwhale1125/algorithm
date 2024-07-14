package 백준.greedy._1700_멀티탭스케줄링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(unplugCount(N, K, arr));
    }

    private static int unplugCount(int N, int K, int[] arr) {
        Set<Integer> tab = new HashSet<>();
        int count = 0;

        for(int i=0; i<K; i++) {
            if(tab.contains(arr[i]))
                continue;

            if(tab.size() < N)
                tab.add(arr[i]);
            else {
                int far = -1;
                int unplug = -1;

                for(int device : tab) {
                    int next = Integer.MAX_VALUE;

                    // search condition far & exist
                    for(int j=i+1; j<K; j++) {
                        if(device == arr[j]) {
                            next = j;
                            break;
                        }
                    }

                    // next exist -> j
                    // next not exist -> MAX.VALUE
                    // far condition test & save
                    if(far < next) {
                        far = next;
                        unplug = device;
                    }
                }

                // tab device remove
                tab.remove(unplug);
                // add
                tab.add(arr[i]);
                // count++
                count++;
            }
        }

        return count;
    }
}
