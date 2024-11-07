public class LinkedList<T> {  // Lớp LinkedList sử dụng kiểu dữ liệu tổng quát T
    private Node<T> head;     // Biến head là nút đầu tiên của danh sách liên kết

    public LinkedList() {     // Hàm khởi tạo, khởi tạo danh sách rỗng
        this.head = null;     // Gán head bằng null, nghĩa là danh sách ban đầu rỗng
    }

    // Duyệt qua từng phần tử của danh sách liên kết
    public void traverse() {
        Node<T> tmp = head;   // Biến tạm tmp dùng để duyệt từ head đến cuối danh sách
        while (tmp != null) { // Lặp qua danh sách liên kết cho đến khi gặp null (cuối danh sách)
            System.out.println(tmp.getData());  // In giá trị của node hiện tại
            tmp = tmp.getNext();   // Chuyển đến phần tử tiếp theo
        }
    }

    // Thêm node vào đầu danh sách
    public void addFirst(T item) {
        Node<T> newNode = new Node<>();  // Tạo node mới
        newNode.setData(item);           // Gán dữ liệu cho node mới
        newNode.setNext(this.head);      // Trỏ node mới vào node hiện tại đang đứng đầu danh sách
        this.head = newNode;             // Đặt node mới làm node đầu tiên (head)
    }

    // Thêm node vào cuối danh sách liên kết
    public void addLast(T item) {
        if (head == null) {          // Nếu danh sách đang rỗng
            addFirst(item);          // Thêm phần tử mới vào đầu danh sách
        } else {
            Node<T> newNode = new Node<>(item, null);  // Tạo node mới, next trỏ đến null
            Node<T> tmp = head;       // Biến tạm tmp để duyệt danh sách
            while (tmp.getNext() != null) {  // Duyệt đến node cuối cùng (node có next = null)
                tmp = tmp.getNext();         // Chuyển sang node tiếp theo
            }
            tmp.setNext(newNode);    // Gán node cuối cùng trỏ đến node mới
        }
    }

    // Thêm node phía sau một node chứa giá trị key
    public void insertAfter(T key, T toInsert) {
        Node<T> tmp = head;   // Biến tạm tmp để duyệt danh sách từ đầu
        while (tmp != null && !tmp.getData().equals(key)) {  // Tìm node chứa key
            tmp = tmp.getNext();   // Chuyển sang node tiếp theo nếu chưa tìm thấy key
        }

        if (tmp != null) {   // Nếu tìm thấy node chứa key
            Node<T> newNode = new Node<>(toInsert, tmp.getNext());  // Tạo node mới, trỏ đến node sau key
            tmp.setNext(newNode);   // Gán node sau key trỏ đến node mới
        }
    }

    // Xóa một node chứa giá trị key
    public boolean remove(T key){
        if(head == null)   // Nếu danh sách rỗng, không thể xóa
            return false;

        if(head.getData().equals(key)){  // Nếu node đầu tiên chứa key cần xóa
            this.head = head.getNext();  // Cập nhật head trỏ đến node tiếp theo
            return true;
        }

        Node<T> prev = null;    // Node trước node hiện tại
        Node<T> cur = head;     // Node hiện tại bắt đầu từ head

        while(cur!=null && !cur.getData().equals(key)){  // Tìm node chứa key
            prev = cur;          // Giữ node trước node hiện tại
            cur = cur.getNext(); // Chuyển sang node tiếp theo
        }

        if(cur==null)  // Nếu không tìm thấy node chứa key
            return false;

        prev.setNext(cur.getNext());  // Bỏ qua node chứa key, gán node trước trỏ đến node sau
        return true;
    }

    // Kiểm tra danh sách có rỗng không
    public boolean isEmpty(){
        return head==null;  // Trả về true nếu head là null, nghĩa là danh sách rỗng
    }

    // Đếm số lượng phần tử trong danh sách
    public int size(){
        int count = 0;      // Khởi tạo biến đếm
        Node<T> tmp = head; // Biến tạm để duyệt danh sách
        while (tmp != null) {   // Lặp qua từng phần tử cho đến khi hết danh sách
            count++;            // Tăng biến đếm
            tmp = tmp.getNext();  // Chuyển sang node tiếp theo
        }
        return count;  // Trả về số lượng phần tử trong danh sách
    }

    // Tìm xem có phần tử nào chứa giá trị item không
    public boolean findItem(T item){
        Node<T> tmp = head;  // Biến tạm để duyệt danh sách từ đầu
        while (tmp != null) {  // Lặp qua từng phần tử
            if(tmp.getData().equals(item)){  // Nếu tìm thấy phần tử
                return true;  // Trả về true nếu tìm thấy
            }
            tmp = tmp.getNext();  // Chuyển sang node tiếp theo
        }
        return false;  // Nếu không tìm thấy trả về false
    }

    // Getter cho biến head
    public Node<T> getHead() {
        return head;
    }

    // Setter cho biến head
    public void setHead(Node<T> head) {
        this.head = head;
    }
}
