package tdc.edu.vn.myapplication.Model;

public class ChiTietSuDung {
    String maPhong, maTB, ngaySD, soLuong;



    public String getMaPhong() {
        return maPhong;
    }

    public String getMaTB() {
        return maTB;
    }

    public String getNgaySD() {
        return ngaySD;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public void setMaTB(String maTB) {
        this.maTB = maTB;
    }

    public void setNgaySD(String ngaySD) {
        this.ngaySD = ngaySD;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "ChiTietSuDung{" +
                "maPhong='" + maPhong + '\'' +
                ", maTB='" + maTB + '\'' +
                ", ngaySD='" + ngaySD + '\'' +
                ", soLuong='" + soLuong + '\'' +
                '}';
    }
}
