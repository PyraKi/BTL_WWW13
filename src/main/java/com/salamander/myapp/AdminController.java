package com.salamander.myapp;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.salamander.entities.ChiTietHoaDon;
import com.salamander.entities.HoaDon;
import com.salamander.entities.LoaiSanPham;
import com.salamander.entities.NhaCungCap;
import com.salamander.entities.SanPham;
import com.salamander.service.ChiTietHoaDonService;
import com.salamander.service.HoaDonService;
import com.salamander.service.LoaiSanPhamService;
import com.salamander.service.NhaCungCapService;
import com.salamander.service.SanPhamService;

@Controller
public class AdminController {

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private LoaiSanPhamService lspService;

	@Autowired
	private NhaCungCapService nccService;

	@Autowired
	private HoaDonService hdService;

	@Autowired
	private ChiTietHoaDonService cthdService;

	public int ids;

	@RequestMapping(value = {"/Quanlysp" }, method = RequestMethod.GET) 
	public String listSanPham(Model model) throws Exception {
		SanPham sp = new SanPham();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		List<SanPham> dssp = sanPhamService.listSanPhams();
		for(int i=0;i<dssp.size();i++) {

			Date date = new Date(dssp.get(i).getNamSXSP().getYear(), dssp.get(i).getNamSXSP().getMonth(), dssp.get(i).getNamSXSP().getDay());
			System.out.println(date);
			System.out.println(dssp.get(i).getNamSXSP());

		}

		//sp.getDsNCC();

		model.addAttribute("loaisanpham",new LoaiSanPham());
		model.addAttribute("dslsp", this.lspService.listLSPs());

		model.addAttribute("dssp", dssp);
		return "Quanlysp";
	}

	@RequestMapping(value = {"/Quanlylsp" }, method = RequestMethod.GET) 
	public String listLoaiSanPham(Model model) {
		model.addAttribute("loaisanpham",new SanPham());
		model.addAttribute("dslsp", this.lspService.listLSPs());
		return "Quanlylsp";
	}
	@RequestMapping(value = {"/Quanlyhoadon" }, method = RequestMethod.GET) 
	public String Quanlyhoadon(Model model) {

		model.addAttribute("hoadon",new HoaDon());
		model.addAttribute("dshd", this.hdService.listHDs());

		model.addAttribute("cthd",new ChiTietHoaDon());
		model.addAttribute("dscthd", this.cthdService.listCTHDs());

		return "Quanlyhoadon";
	}


	@RequestMapping("/quanlysp")
	public ModelAndView removeSp(HttpServletRequest request ,@RequestParam long idspan){
		List<SanPham> dssp = this.sanPhamService.listSanPhams();
		List<NhaCungCap> dsncc=this.nccService.listNCCs();
		for(NhaCungCap ncc:dsncc) {
			if(ncc.getSp().getIdSP()==idspan) {

				this.nccService.removeNCC(ncc.getIdNCC());
				this.sanPhamService.removeSanPham(idspan);
				return new ModelAndView("redirect:/Quanlysp","complet","Xóa sản phẩm thành công");
			}

			//			

		}

		return new ModelAndView("redirect:/Quanlysp","Error","Xóa sản phẩm lỗi");
	}

	@RequestMapping("/removelsp/{idlSP}")
	public ModelAndView removelsp(@PathVariable("idlSP") int idlSP){
		List<SanPham> dssp = sanPhamService.listSanPhams();

		for(SanPham sp : dssp) {
			if(sp.getLoaisp().getIdLoaiSP()==idlSP) {
				System.out.println("meo");
				return new ModelAndView("redirect:/Quanlylsp");
			}
		}
		this.lspService.removeLSP(idlSP);
		return new ModelAndView("redirect:/Quanlylsp");
	}


	@RequestMapping(value = {"updatesp" }, method = RequestMethod.POST) 
	public ModelAndView listLSPs(HttpServletRequest request,Model model,@RequestParam long idan,@ModelAttribute("sp") SanPham sp) {

		String name = request.getParameter("namesp");
		String gia = request.getParameter("gia");
		float giasp = Float.parseFloat(gia);
		String sl = request.getParameter("sl");
		int soluong = Integer.parseInt(sl);
		String mota = request.getParameter("mota");
		Date namsx =Date.valueOf(request.getParameter("namsx"));
		Date timebh = Date.valueOf(request.getParameter("timebh"));
		String tskt = request.getParameter("tskt");
		String img = request.getParameter("img");
		long idlsp = Long.parseLong(request.getParameter("idlsp"));

		LoaiSanPham lsp= lspService.getLSPById(idlsp);

		sp = new SanPham(idan, name, soluong, giasp, namsx, mota, tskt, timebh, img);
		sp.setLoaisp(lsp);
		sanPhamService.updateSanPham(sp);

		return new ModelAndView("redirect:/Quanlylsp");
	}

	@RequestMapping("/addSua")
	public String edit(Model model,HttpServletRequest request ,@RequestParam("idspan") int idspan){
		SanPham sp = sanPhamService.getPersonById(idspan);

		model.addAttribute("sp", sp);

		model.addAttribute("dslsp", this.lspService.listLSPs());
		return "editsp";
	}
        
        @RequestMapping(value = {"/addSanpham" }, method = RequestMethod.GET) 
	public String listLSPs(Model model) {
		model.addAttribute("loaisp",new LoaiSanPham());
                
		model.addAttribute("dslsp", this.lspService.listLSPs());
		return "editsp";
	}
        
	@RequestMapping(value = {"updateSP"},method = RequestMethod.POST)
	public ModelAndView addSP(HttpServletRequest Request) {

                
		long idsp = 0;
		SanPham sp = new SanPham();
                
		String namesp = Request.getParameter("namesp");
		float gia =Float.parseFloat(Request.getParameter("gia"));
		int sl = Integer.parseInt(Request.getParameter("sl"));
		String mota = Request.getParameter("mota");
		Date namsx =Date.valueOf(Request.getParameter("namsx"));
		Date timebh = Date.valueOf(Request.getParameter("timebh"));
		String tskt = Request.getParameter("tskt");
		String img = Request.getParameter("img");
		long idlsp = Long.parseLong(Request.getParameter("idlsp"));
                LoaiSanPham lsp= lspService.getLSPById(idlsp);
                
                if(Request.getParameter("idsp") == ""){
                    idsp = (long) (Math.random() * (10000));
                    sp = new SanPham(idsp, namesp, sl, gia, namsx, mota, tskt, timebh, img);
                    sp.setLoaisp(lsp);
                    sanPhamService.addSanPham(sp);
                    return new ModelAndView("redirect:/Quanlysp");
                } else {
                    idsp = Long.parseLong(Request.getParameter("idsp"));
                    sp.setTenSP(namesp);
                    sp.setSoLuong(sl);
                    sp.setGiaSP(gia);
                    sp.setNamSXSP(namsx);
                    sp.setMoTa(mota);
                    sp.setThongSoKiThuat(tskt);
                    sp.setThoiGianBaoHanh(timebh);
                    sp.setUrl(img);
                    sp.setLoaisp(lsp);

                    sanPhamService.updateSanPham(sp);

                    return new ModelAndView("redirect:/Quanlysp");
                }

	}

}
