package com.bby.hotel.controller;

import com.bby.hotel.base.BaseController;
import com.bby.hotel.exception.BusinessException;
import com.bby.hotel.exception.EmErrorMsg;
import com.bby.hotel.model.TabUserInfoModel;
import com.bby.hotel.net.CommonReturnType;
import com.bby.hotel.net.request.ApiLoginRequest;
import com.bby.hotel.net.response.ApiLoginResponse;
import com.bby.hotel.services.ILoginServices;
import com.bby.hotel.utils.Base65Utils;
import com.bby.hotel.utils.ResponseUtils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
@RequestMapping(value = "/api/login", method = RequestMethod.POST)
public class LoginController extends BaseController {

    @Autowired
    private ILoginServices mLoginServices;

    @PostMapping(value = "",consumes = {CONSUMES_TYPE})
    public CommonReturnType login(HttpServletRequest request) throws Exception {

        //test cookie
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie c : cookies) {
                System.out.println("c.getDomain = " + c.getDomain()+",c.getName = "+ c.getName() + ",c.getValue = "+ c.getValue());
            }
        }else{
            System.out.println("cookie 获取 null");
        }

        //test session
        ApiLoginResponse curUser = (ApiLoginResponse)request.getSession().getAttribute("curUser");

        if(curUser != null){
            System.out.println("从session取出的user:"+curUser.getUser_nick());
        }else{
            System.out.println("从session取出的user:为空啊!!!");
        }

        String jData = request.getParameter("data");
        if (jData != null) {
            ApiLoginRequest mLoginRequest = new Gson().fromJson(jData, ApiLoginRequest.class);
            if (mLoginRequest != null) {
                //说明获取参数成功
                String encodePwd = Base65Utils.getInstance().base64Encode(mLoginRequest.getPassWord());
                TabUserInfoModel mTabUserInfoModel = mLoginServices.login(mLoginRequest.getAccount());
                if (mTabUserInfoModel != null) {
                    //获取到用户信息，构造一个前台需要的model 返回
                    if (mTabUserInfoModel.getPass_word().equals(encodePwd)) {
                        ApiLoginResponse mApiLoginResponse = getUserResponseModel(mTabUserInfoModel);
                        //添加到session 中 用户model
                        request.getSession().setAttribute("curUser", mApiLoginResponse);
                        return ResponseUtils.getResponseSuc(mApiLoginResponse);
                    } else {
                        //密码错误
                        throw new BusinessException(EmErrorMsg.USER_PASSWORD_NOT_MATCH_ERROR);
                    }
                } else {
                    //获取用户为空
                    throw new BusinessException(EmErrorMsg.USER_NOT_EXIT_ERROR);
                }
            }else{
                //获取参数错误
                throw new BusinessException(EmErrorMsg.PARAMETER_VALIDATION_ERROR);
            }
        }
        //获取参数为空
        throw new BusinessException(EmErrorMsg.PARAMETER_VALIDATION_ERROR);
    }

    /**
     * 构造一个前台需要的model 返回
     *
     * @param model 用户信息
     * @return ApiLoginResponse
     */
    private ApiLoginResponse getUserResponseModel(TabUserInfoModel model) {
        ApiLoginResponse result = new ApiLoginResponse();
        result.setId(model.getId());
        result.setAccount(model.getAccount());
        result.setRemark(model.getRemark());
        result.setUser_nick(model.getUser_nick());
        return result;
    }



    //    main
    public static void main(String[] args) {
        System.out.println("123456 =>" + Base65Utils.getInstance().base64Encode("123456"));
        System.out.println("123 =>" + Base65Utils.getInstance().base64Decode("MTIzNDU2"));

    }
}
