package com.fh.biz.type;

import com.fh.mapper.type.ITypeMapper;
import com.fh.po.type.Type;
import com.fh.utils.SystemConstant;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("typeService")
public class ITypeServiceImpl implements ITypeService {
    @Resource
    private ITypeMapper typeMapper;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;


  public Object queryTypeList() {
     Boolean isExists  = redisTemplate.hasKey("type");
      Object type = null;
      if(isExists){
         type = redisTemplate.opsForValue().get("type");
      }else{
          List<Type> typeAll = typeMapper.queryTypeList();
          type = getType(0, typeAll);
          redisTemplate.opsForValue().set("type", type);
      }

      return type;
  }
  private List<Map<String,Object>> getType(Integer pid, List<Type> typeAll){
      List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
      typeAll.forEach(type->{
          Map<String, Object> map=null;
          if(pid.equals(type.getPId())){
              map=new HashMap<String, Object>();
              map.put("id",type.getId());
              map.put("name",type.getName());
              map.put("children",getType(type.getId(),typeAll));
          }
          if(map != null){
              list.add(map);
          }
      });
      return list;
  }
}
