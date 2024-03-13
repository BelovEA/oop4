import gb_collections.Lists.GbArrayList;
import gb_collections.GbList;

public class Main {
    public static void main(String[] args) {
        GbList<Integer> list = new GbArrayList<>();
        list.add(0);
        System.out.println(list.size());
        System.out.println(list);
        list.add(3);
        list.add(33);
        list.add(3);
        list.add(333);
        list.add(3333);
        list.removeByIndex(1);
        list.remove(333);
        System.out.println(list);
        GbList<String> s = new GbArrayList<>();
        s.add("asdf");
        s.add("xcdf");
        s.add("hjdf");
        s.add("lkjf");
    }
}