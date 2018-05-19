CREATE OR REPLACE PROCEDURE generarAutoUserPass(v_dni in VARCHAR , v_nombre in VARCHAR, v_apellido in VARCHAR, v_tipo in VARCHAR, v_codlogin out INTEGER) AS
  usuario varchar (30);
  contrasenia varchar(30);
BEGIN 
  usuario := v_dni;
  contrasenia := lower(substr(v_nombre,1,1) || v_apellido);
  
  INSERT INTO login  (usuario, passwd, tipo) VALUES (usuario, contrasenia, v_tipo) RETURNING codlogin INTO v_codlogin;
EXCEPTION 
  WHEN OTHERS THEN 
    RAISE_APPLICATION_ERROR(-20100, 'Error en pr_Crea_Login: '||SQLERRM);
END;