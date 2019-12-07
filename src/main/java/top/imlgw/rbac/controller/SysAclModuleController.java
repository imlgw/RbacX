package top.imlgw.rbac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.imlgw.rbac.result.CodeMsg;
import top.imlgw.rbac.result.Result;
import top.imlgw.rbac.service.SysAclModuleService;
import top.imlgw.rbac.service.SysTreeService;
import top.imlgw.rbac.validator.NeedLogin;
import top.imlgw.rbac.vo.AclModuleLevelVo;
import top.imlgw.rbac.vo.AclModuleVo;

import java.util.List;

/**
 * @author imlgw.top
 * @date 2019/12/6 23:45
 */
@Controller
@RequestMapping("/system/aclModule")
public class SysAclModuleController {

    @Autowired
    private SysAclModuleService sysAclModuleService;


    @Autowired
    private SysTreeService sysTreeService;

    @PostMapping("/save")
    @ResponseBody
    @NeedLogin
    public Result saveAclModule(@Validated @RequestBody AclModuleVo aclModuleVo){
        sysAclModuleService.save(aclModuleVo);
        return Result.success(CodeMsg.SUCCESS);
    }

    @PostMapping("/update")
    @ResponseBody
    @NeedLogin
    public Result updateAclModule(@Validated @RequestBody AclModuleVo aclModuleVo){
        sysAclModuleService.update(aclModuleVo);
        return Result.success(CodeMsg.SUCCESS);
    }


    @RequestMapping("/tree")
    @ResponseBody
    //@NeedLogin
    public Result treeAclModule(){
        List<AclModuleLevelVo> aclModuleTree = sysTreeService.createAclModuleTree();
        return Result.success(aclModuleTree);
    }

}
