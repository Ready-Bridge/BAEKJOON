import java.io.*;
import java.util.*;

public class Main {

    public static class Room {

        ArrayList<String[]> list;
        boolean isStart;
        int value;

        public Room(int value) {
            this.value = value;
            isStart = false;
            list = new ArrayList<>();
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean flag;

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Room> rooms = new ArrayList<>();

        for(int i = 0; i < p; i++) {
            flag = true;
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            for(Room room : rooms) {
                if(room.value - 10 <= l && room.value + 10 >= l) {
                    if(!room.isStart) {
                        room.list.add(new String[] {n, String.valueOf(l)});
                        flag = false;

                        if(room.list.size() == m) {
                            room.isStart = true;
                        }

                        break;
                    }
                }
            }

            if(flag) {
                Room temp = new Room(l);
                rooms.add(temp);
                temp.list.add(new String[] {n, String.valueOf(l)});
                
                if(temp.list.size() == m) {
                    temp.isStart = true;
                }
            }
        }



        for(Room room : rooms) {
            if(room.isStart) {
                bw.write("Started!");
                bw.write("\n");
            } else {
                bw.write("Waiting!");
                bw.write("\n");
            }

            Collections.sort(room.list, Comparator.comparing(a -> a[0]));

            for(int i = 0; i < room.list.size(); i++) {
                bw.write(room.list.get(i)[1] + " " + room.list.get(i)[0]);
                bw.write("\n");
            }
        }

        bw.close();

    }
}