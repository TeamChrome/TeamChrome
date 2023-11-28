package src.main.java;

import java.util.UUID;

public class Guest {
        private final String name;
        private String email;
        private String phoneNum;
        private String address;
        private String id;

        public Guest (String name, String email, String phoneNum, String address) {
            this.name = name;
            this.email = email;
            this.phoneNum = phoneNum;
            this.address = address;
            this.id = UUID.randomUUID().toString();
        }

        public String getName() {
                return name;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
         }

        public String getEmail() {
                return email;
        }

        public void setEmail (String email) {
                this.email = email;
        }

        public String getPhoneNum() {
                 return phoneNum;
        }

        public void setPhoneNum (String phoneNum) {
                this.phoneNum = phoneNum;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress (String address) {
                 this.address = address;
        }


    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", address='" + address + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
