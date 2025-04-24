package 프로그래머스.level2.kakao.메뉴리뉴얼;

import java.util.*;
import java.util.stream.*;

public class Solution {

    private interface RestaurantOwner {
        String[] makeUp(String[] orders, int[] course);
    }

    private static class Course {
        public final String course;
        public final int occurrences;

        public Course(String course, int occurrences) {
            this.course = course;
            this.occurrences = occurrences;
        }
    }

    private static class Skarpy implements RestaurantOwner {

        private List<Set<String>> changeOrderList(String[] orders) {
            return Arrays.stream(orders)
                    .map(order -> order.chars()
                            .mapToObj(c -> String.valueOf((char) c))
                            .collect(Collectors.toSet()))
                    .collect(Collectors.toList());
        }

        private Map<Integer, List<Course>> initCourseMap(int[] course) {
            return Arrays.stream(course)
                    .boxed()
                    .collect(Collectors.toMap(
                            courseNum -> courseNum,
                            courseNum -> new ArrayList(List.of(new Course("", 0)))));
        }

        @Override
        public String[] makeUp(String[] orders, int[] course) {
            List<Set<String>> orderList = changeOrderList(orders);
            Map<Integer, List<Course>> courses = initCourseMap(course);

            getCourses('A', new HashSet<>(), orderList, courses);

            return courses.values().stream()
                    .filter(list -> list.get(0).occurrences > 0)
                    .flatMap(List::stream)
                    .map(c -> c.course)
                    .sorted()
                    .toArray(String[]::new);
        }

        private void getCourses(char nextMenu, Set<String> selectedMenus,
                                List<Set<String>> orderList, Map<Integer, List<Course>> courses) {
            int occurrences = (int) orderList.stream()
                    .filter(order -> order.containsAll(selectedMenus))
                    .count();

            /* 등장 횟수가 2회 미만인 조합은 메뉴를 더 추가해도 등장 횟수가 2회 이상이 될 수 없음 */
            if (occurrences < 2) return;

            int size = selectedMenus.size();

            /* 만약 size가 문제에서 주어진 course 배열에 포함되어있을 경우 정답 기록 */
            if (courses.containsKey(size)) {
                List<Course> courseList = courses.get(size);
                Course course = new Course(selectedMenus.stream()
                        .sorted()
                        .collect(Collectors.joining()), occurrences);

                Course original = courseList.get(0);

                /* 현재 구한 값이 List에 저장된 값보다 크다면 List를 비우고 값 저장 */
                if (original.occurrences < occurrences) {
                    courseList.clear();
                    courseList.add(course);
                /* 값이 같다면 요구사항 그대로 저장 */
                } else if (original.occurrences == course.occurrences) {
                    courseList.add(course);
                }
            }

            if (size >= 10) return;

            for (char menu = nextMenu; menu <= 'Z'; menu++) {
                String menuStr = String.valueOf(menu);
                selectedMenus.add(menuStr);
                getCourses((char) (menu + 1), selectedMenus, orderList, courses);
                selectedMenus.remove(menuStr);
            }
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        RestaurantOwner shef = new Skarpy();
        return shef.makeUp(orders, course);
    }
}
