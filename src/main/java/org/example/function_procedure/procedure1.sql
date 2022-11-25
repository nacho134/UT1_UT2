CREATE OR REPLACE PROCEDURE public.borracategorias2()
	LANGUAGE plpgsql
AS $procedure$
	BEGIN
		 DELETE FROM categorias WHERE categoriaid = 7;
	END;
$procedure$
;

