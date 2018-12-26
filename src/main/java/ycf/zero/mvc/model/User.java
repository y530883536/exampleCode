package ycf.zero.mvc.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import ycf.zero.mvc.common.annotation.Table;


/**
 *  @author yeChangFeng 创建于 2018-12-24 17:19:08
 */
@Table(name = "user" , id = "id")
@Setter
@Getter
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final String GENDER = "gender";
	public static final String ID = "id";
	public static final String NAME = "name";

    private Integer id;
    private String name;
    private Byte gender;

}