package tdc.edu.vn.myapplication.Model;

public class PhongHoc {
    String maPhong, loaiPhong, tang;

    public String getMaPhong() {
        return maPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public String getTang() {
        return tang;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public void setTang(String tang) {
        this.tang = tang;
    }

    @Override
    public String toString() {
        return "PhongHoc{" +
                "maPhong='" + maPhong + '\'' +
                ", loaiPhong='" + loaiPhong + '\'' +
                ", tang='" + tang + '\'' +
                '}';
    }
}
