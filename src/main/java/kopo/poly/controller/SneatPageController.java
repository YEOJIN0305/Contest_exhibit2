package kopo.poly.controller;

import kopo.poly.dto.MemoDTO;
import kopo.poly.dto.NoticeDTO;
import kopo.poly.dto.UserInfoDTO;
import kopo.poly.service.INoticeService;
import kopo.poly.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class SneatPageController {
    //서비스로 연결
    @Resource(name = "UserService")
    private IUserService userService;

    //서비스로 연결
    @Resource(name = "NoticeService")
    private INoticeService noticeService;

    @GetMapping(value="/sneat/documentation")
    public String documentaion() throws Exception {
        log.info(this.getClass().getName()+".docPage Start!");
        return "/sneat/documentation";
    }
    @GetMapping(value="/sneat/upgradePro")
    public String upgradePro() throws Exception {
        log.info(this.getClass().getName()+".upgradePro Start!");
        return "/sneat/upgradePro";
    }

    @GetMapping(value="/sneat/index")
    public String index() throws Exception {
        log.info(this.getClass().getName()+".index Start!");
        return "/sneat/index";
    }

    @GetMapping(value="/sneat/main-page")
    public String mainpage(HttpServletRequest request, Model model, HttpSession session) throws Exception {
        log.info(this.getClass().getName()+".main-page Start!");
        String user_seq = (String) session.getAttribute("sessionNo");
        log.info("user_seq : "+user_seq);
/*
        UserInfoDTO uDTO = new UserInfoDTO();
        uDTO.setUser_seq(user_seq);
        UserInfoDTO rDTO = userService.getUserDetail(uDTO);*/

        List<NoticeDTO> rList = noticeService.getNoticeLimitThree();
        log.info("사이즈 : "+String.valueOf(rList.size()));
        if(rList == null){
            rList = new ArrayList<>();
        }
        model.addAttribute("rList", rList);

        List<MemoDTO> memoList = noticeService.getNoticeMemoList();
        log.info("사이즈 : "+String.valueOf(memoList.size()));
        if(memoList == null){
            memoList = new ArrayList<>();
        }
        model.addAttribute("memoList", memoList);

        log.info(this.getClass().getName()+".main-page End!");
        return "/sneat/main-page";
    }

    @GetMapping(value="/sneat/auth-forgot-id-basic")
    public String authForgotId() throws Exception {
        log.info(this.getClass().getName()+".auth-forgot id Start!");
        return "/sneat/auth-forgot-id-basic";
    }

    @GetMapping(value="/sneat/auth-forgot-id-find")
    public String authFindId() throws Exception {
        log.info(this.getClass().getName()+".authFindId Start!");
        log.info(this.getClass().getName()+".authFindId End!");
        return "/sneat/auth-forgot-id-find";
    }

    @GetMapping(value="/sneat/auth-forgot-password-basic")
    public String authForgot() throws Exception {
        log.info(this.getClass().getName()+".auth-forgot Start!");
        return "/sneat/auth-forgot-password-basic";
    }

    @GetMapping(value="/sneat/auth-login-basic")
    public String authLogin() throws Exception {
        log.info(this.getClass().getName()+".auth-forgot Start!");
        return "/sneat/auth-login-basic";
    }

    @GetMapping(value="/sneat/auth-register-basic")
    public String authRegister() throws Exception {
        log.info(this.getClass().getName()+".auth-register Start!");
        return "/sneat/auth-register-basic";
    }

    @GetMapping(value="/sneat/cards-basic")
    public String cardsBasic() throws Exception {
        log.info(this.getClass().getName()+".cardsBasic Start!");
        return "/sneat/cards-basic";
    }

    @GetMapping(value="/sneat/extended-ui-perfect-scrollbar")
    public String extendedUiPerfect() throws Exception {
        log.info(this.getClass().getName()+".extendedUiPerfect Start!");
        return "/sneat/extended-ui-perfect-scrollbar";
    }

    @GetMapping(value="/sneat/extended-ui-text-divider")
    public String extendedUiText() throws Exception {
        log.info(this.getClass().getName()+".extendedUiText Start!");
        return "/sneat/extended-ui-text-divider";
    }

    @GetMapping(value="/sneat/form-layouts-horizontal")
    public String formLayoutsHoriaontal() throws Exception {
        log.info(this.getClass().getName()+".formLayoutsHoriaontal Start!");
        return "/sneat/form-layouts-horizontal";
    }

    @GetMapping(value="/sneat/form-layouts-vertical")
    public String formLayoutsVertical() throws Exception {
        log.info(this.getClass().getName()+".formLayoutsVertical Start!");
        return "/sneat/form-layouts-vertical";
    }

    @GetMapping(value="/sneat/forms-basic-inputs")
    public String formsBasic() throws Exception {
        log.info(this.getClass().getName()+".formsBasic Start!");
        return "/sneat/forms-basic-inputs";
    }

    @GetMapping(value="/sneat/forms-input-groups")
    public String formsInput() throws Exception {
        log.info(this.getClass().getName()+".formsInput Start!");
        return "/sneat/forms-input-groups";
    }

    @GetMapping(value="/sneat/icons-boxicons")
    public String boxicons() throws Exception {
        log.info(this.getClass().getName()+".iconsBoxicons Start!");
        return "/sneat/icons-boxicons";
    }

    @GetMapping(value="/sneat/layouts-blank")
    public String layoutsBlank() throws Exception {
        log.info(this.getClass().getName()+".layoutsBlank Start!");
        return "/sneat/layouts-blank";
    }

    @GetMapping(value="/sneat/layouts-container")
    public String layoutsContainer() throws Exception {
        log.info(this.getClass().getName()+".layoutsContainer Start!");
        return "/sneat/layouts-container";
    }

    @GetMapping(value="/sneat/layouts-fluid")
    public String layoutsFluid() throws Exception {
        log.info(this.getClass().getName()+".layoutsFluid Start!");
        return "/sneat/layouts-fluid";
    }

    @GetMapping(value="/sneat/layouts-without-menu")
    public String layoutsMenu() throws Exception {
        log.info(this.getClass().getName()+".layoutsMenu Start!");
        return "/sneat/layouts-without-menu";
    }

    @GetMapping(value="/sneat/layouts-without-navbar")
    public String layoutsNavbar() throws Exception {
        log.info(this.getClass().getName()+".layoutsNavbar Start!");
        return "/sneat/layouts-without-navbar";
    }

    @GetMapping(value="/sneat/pages-account-settings-account")
    public String pasa() throws Exception {
        log.info(this.getClass().getName()+".pasa Start!");
        return "/sneat/pages-account-settings-account";
    }

    @GetMapping(value="/sneat/pages-account-settings-connections")
    public String pasc() throws Exception {
        log.info(this.getClass().getName()+".pasc Start!");
        return "/sneat/pages-account-settings-connections";
    }

    @GetMapping(value="/sneat/pages-account-settings-notifications")
    public String pasn() throws Exception {
        log.info(this.getClass().getName()+".pasn Start!");
        return "/sneat/pages-account-settings-notifications";
    }

    @GetMapping(value="/sneat/pages-misc-error")
    public String pme() throws Exception {
        log.info(this.getClass().getName()+".pme Start!");
        return "/sneat/pages-misc-error";
    }

    @GetMapping(value="/sneat/pages-misc-under-maintenance")
    public String pmum() throws Exception {
        log.info(this.getClass().getName()+".pmum Start!");
        return "/sneat/pages-misc-under-maintenance";
    }

    @GetMapping(value="/sneat/tables-basic")
    public String tablesBasic() throws Exception {
        log.info(this.getClass().getName()+".tables-basic Start!");
        return "/sneat/tables-basic";
    }

    @GetMapping(value="/sneat/ui-accordion")
    public String uiAccordion() throws Exception {
        log.info(this.getClass().getName()+".ui-accordion Start!");
        return "/sneat/ui-accordion";
    }

    @GetMapping(value="/sneat/ui-alerts")
    public String uiAlerts() throws Exception {
        log.info(this.getClass().getName()+".uiAlerts Start!");
        return "/sneat/ui-alerts";
    }

    @GetMapping(value="/sneat/ui-badges")
    public String uiBadges() throws Exception {
        log.info(this.getClass().getName()+".uiBadges Start!");
        return "/sneat/ui-badges";
    }

    @GetMapping(value="/sneat/ui-buttons")
    public String uiButtons() throws Exception {
        log.info(this.getClass().getName()+".uiButtons Start!");
        return "/sneat/ui-buttons";
    }

    @GetMapping(value="/sneat/ui-carousel")
    public String uiCarousel() throws Exception {
        log.info(this.getClass().getName()+".uiCarousel Start!");
        return "/sneat/ui-carousel";
    }

    @GetMapping(value="/sneat/ui-collapse")
    public String uiCollapse() throws Exception {
        log.info(this.getClass().getName()+".uiCollapse Start!");
        return "/sneat/ui-collapse";
    }

    @GetMapping(value="/sneat/ui-dropdowns")
    public String uiDropdowns() throws Exception {
        log.info(this.getClass().getName()+".uiDropdowns Start!");
        return "/sneat/ui-dropdowns";
    }

    @GetMapping(value="/sneat/ui-footer")
    public String uiFooter() throws Exception {
        log.info(this.getClass().getName()+".uiFooter Start!");
        return "/sneat/ui-footer";
    }

    @GetMapping(value="/sneat/ui-list-groups")
    public String uiListGroups() throws Exception {
        log.info(this.getClass().getName()+".uiListGroups Start!");
        return "/sneat/ui-list-groups";
    }

    @GetMapping(value="/sneat/ui-modals")
    public String uiModals() throws Exception {
        log.info(this.getClass().getName()+".uiModals Start!");
        return "/sneat/ui-modals";
    }

    @GetMapping(value="/sneat/ui-navbar")
    public String uiNavbar() throws Exception {
        log.info(this.getClass().getName()+".uiNavbar Start!");
        return "/sneat/ui-navbar";
    }

    @GetMapping(value="/sneat/ui-offcanvas")
    public String uiOffcanvas() throws Exception {
        log.info(this.getClass().getName()+".uiOffcanvas Start!");
        return "/sneat/ui-offcanvas";
    }

    @GetMapping(value="/sneat/ui-pagination-breadcrumbs")
    public String uiPaginationBreadcrumbs() throws Exception {
        log.info(this.getClass().getName()+".uiPaginationBreadcrumbs Start!");
        return "/sneat/ui-pagination-breadcrumbs";
    }

    @GetMapping(value="/sneat/ui-progress")
    public String uiProgress() throws Exception {
        log.info(this.getClass().getName()+".uiProgress Start!");
        return "/sneat/ui-progress";
    }

    @GetMapping(value="/sneat/ui-spinners")
    public String uiSpinners() throws Exception {
        log.info(this.getClass().getName()+".uiSpinners Start!");
        return "/sneat/ui-spinners";
    }

    @GetMapping(value="/sneat/ui-tabs-pills")
    public String uiTabsPills() throws Exception {
        log.info(this.getClass().getName()+".uiTabsPills Start!");
        return "/sneat/ui-tabs-pills";
    }

    @GetMapping(value="/sneat/ui-toasts")
    public String uiToasts() throws Exception {
        log.info(this.getClass().getName()+".uiToasts Start!");
        return "/sneat/ui-toasts";
    }

    @GetMapping(value="/sneat/ui-tooltips-popovers")
    public String uiTooltipsPopovers() throws Exception {
        log.info(this.getClass().getName()+".uiTooltipsPopovers Start!");
        return "/sneat/ui-tooltips-popovers";
    }

    @GetMapping(value="/sneat/ui-typography")
    public String uiTypography() throws Exception {
        log.info(this.getClass().getName()+".uiTypography Start!");
        return "/sneat/ui-typography";
    }
}

