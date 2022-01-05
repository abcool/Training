<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>H+ Sports</title>
<style type="text/css">
body {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 14px;
}

.header {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 18px;
}

.bottom {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 9px;
	text-align: center;
	vertical-align: middle;
	color: #8E969D;
}
</style>
<link type="text/css" rel="stylesheet" href="resources/css/global.css" />
</head>
<body>
	<table style="border: 1px solid #CAD6E0" align="center" cellpadding="0"
		cellspacing="0" border="0" width="400">
		<tbody>

			<tr>
				<td class="header" height="42" align="center" valign="middle"
					width="100%" bgcolor="#E4EBEB">Entry Form | Catalog </td>
			</tr>
			<tr>
				<td height="1" width="100%" bgcolor="#CAD6E0"></td>
			</tr>
			<tr>
				<td><img src="resources/img/banner.jpeg" alt="banner.jpeg"/></td>
			</tr>
			<tr>
				<td width="100%" colspan="2">
					<table width="100%" align="left"
						cellpadding="0" cellspacing="0" border="0">
						${pageContext.request.contextPath }<br/>
						${param.name }<br/>
						<h3> Cookie: ${cookie.CatalogCookie.value }</h3><br/>
						<h3>Total items in Catalog: ${CatalogItems.size() }</h3>
						<tbody>
							<tr>
								<th>Name</th>
								<th>Manufacturer</th>
								<th>SKU</th>
							</tr>
							<c:forEach var="item" items="${CatalogItems}">
							<tr>
								<td>
									<c:out value="${item.name}"></c:out>		
								</td>
								<td>
									<c:out value="${item.manufacturer}"></c:out>
								</td>
								<td>
									<c:out value="${item.sku}"></c:out>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</td>
			</tr>

			<tr>
				<td colspan="2" valign="bottom" height="1" width="100%"
					bgcolor="#CAD6E0"></td>
			</tr>
		</tbody>
	</table>
</body>

</html>
