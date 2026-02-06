import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private final List<Contact> contacts = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final String FILE_PATH = "data/contacts.csv";
    private final String PHONE_REGEX = "^0[0-9]{9}$";
    private final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private final String DIVIDER = "+-----------------+--------------+----------------------+------------+---------------------------+--------------+---------------------------+";
    private final String HEADER = String.format("| %-15s | %-12s | %-20s | %-10s | %-25s | %-12s | %-25s |",
            "Số điện thoại", "Nhóm", "Họ tên", "Giới tính", "Địa chỉ", "Ngày sinh", "Email");

    public void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        printTableHeader();
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i));
            if ((i + 1) % 5 == 0 && i < contacts.size() - 1) {
                System.out.println(DIVIDER);
                System.out.println(">>> Nhấn Enter để xem tiếp danh sách...");
                scanner.nextLine();
                printTableHeader();
            }
        }
        System.out.println(DIVIDER);
    }

    public void addContact() {
        System.out.println("--- THÊM MỚI DANH BẠ ---");
        String phone = validateInput("Nhập số điện thoại (10 số): ", PHONE_REGEX);
        System.out.print("Nhập nhóm: ");
        String group = scanner.nextLine();
        System.out.print("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String birth = scanner.nextLine();
        String email = validateInput("Nhập email: ", EMAIL_REGEX);

        contacts.add(new Contact(phone, group, name, gender, address, birth, email));
        System.out.println("Thêm mới thành công!");
    }

    public void updateContact() {
        System.out.print("Nhập số điện thoại cần sửa: ");
        String phone = scanner.nextLine();
        if (phone.isEmpty()) return;

        Contact found = findByPhone(phone);
        if (found == null) {
            System.out.println("Không tìm được danh bạ với số điện thoại trên.");
            updateContact();
        } else {
            System.out.print("Nhập nhóm mới: "); found.setGroup(scanner.nextLine());
            System.out.print("Nhập tên mới: "); found.setFullName(scanner.nextLine());
            System.out.print("Nhập giới tính mới: "); found.setGender(scanner.nextLine());
            System.out.print("Nhập địa chỉ mới: "); found.setAddress(scanner.nextLine());
            System.out.print("Nhập ngày sinh mới: "); found.setBirthDate(scanner.nextLine());
            found.setEmail(validateInput("Nhập email mới: ", EMAIL_REGEX));
            System.out.println("Cập nhật thành công!");
        }
    }


    public void deleteContact() {
        System.out.print("Nhập số điện thoại cần xóa: ");
        String phone = scanner.nextLine();
        if (phone.isEmpty()) return;

        Contact found = findByPhone(phone);
        if (found == null) {
            System.out.println("Không tìm được danh bạ với số điện thoại trên.");
            deleteContact();
        } else {
            System.out.print("Xác nhận xóa? (Nhập Y để xóa): ");
            if (scanner.nextLine().equalsIgnoreCase("Y")) {
                contacts.remove(found);
                System.out.println("Đã xóa thành công!");
            }
        }
    }


    public void searchContact() {
        System.out.print("Nhập từ khóa tìm kiếm (SĐT hoặc Tên): ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean foundMatch = false;

        for (Contact c : contacts) {
            if (c.getPhoneNumber().contains(keyword) || c.getFullName().toLowerCase().contains(keyword)) {
                if (!foundMatch) {
                    printTableHeader();
                    foundMatch = true;
                }
                System.out.println(c);
            }
        }
        if (!foundMatch) System.out.println("Không tìm thấy kết quả nào.");
        else System.out.println(DIVIDER);
    }


    public void writeToFile() {
        System.out.print("Hành động này sẽ ghi đè file. Tiếp tục? (Y/N): ");
        if (!scanner.nextLine().equalsIgnoreCase("Y")) return;

        File directory = new File("data");
        if (!directory.exists()) directory.mkdir();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            bw.write("Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email");
            bw.newLine();

            for (Contact c : contacts) {
                bw.write(c.toCSV());
                bw.newLine();
            }
            System.out.println("Lưu file thành công tại: " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }


    public void readFromFile() {
        System.out.print("Cảnh báo: Toàn bộ danh bạ hiện có sẽ bị xóa. Tiếp tục? (Y/N): ");
        if (!scanner.nextLine().equalsIgnoreCase("Y")) return;

        contacts.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 7) {
                    contacts.add(new Contact(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
                }
            }
            System.out.println("Đọc file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }


    private void printTableHeader() {
        System.out.println(DIVIDER);
        System.out.println(HEADER);
        System.out.println(DIVIDER);
    }

    private Contact findByPhone(String phone) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone))
                return c;
        }
        return null;
    }

    private String validateInput(String message, String regex) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine();
            if (input.matches(regex)) return input;
            System.out.println("Định dạng không hợp lệ, vui lòng nhập lại!");
        }
    }
}