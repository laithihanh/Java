<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : BTH3.xsl
    Created on : August 21, 2020, 2:44 PM
    Author     : ADMIN
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            <head>
                <title>BTH3.xsl</title>
            </head>
            <body>
                <table width="384" height="66" border="1" style="margin:0 auto">
                    <tr>
                        <th scope="col">Title</th>
                        <th scope="col">Author</th>
                        <th scope="col">Pages</th>
                        <th scope="col">Price</th>
                    </tr>
                    <xsl:for-each select="BookList/book">
                    <!-- thêm xsl:sort để sắp xếp tên sách theo thứ tự alphabel.-->
                    <xsl:sort data-type="text" select="name" order="descending" />
                    <!-- lọc các cuốn sách có giá trên $90 bằng xsl:if.-->
                    <xsl:if test="price > 90">
                    <tr>
                        <td>
                            <xsl:value-of select="name" />
                        </td>
                        <td>
                            <xsl:value-of select="author" />
                        </td>
                        <td>
                            <xsl:value-of select="pages" />
                        </td>
                        <td>
                            <xsl:value-of select="price" />
                        </td>
                    </tr>
                    </xsl:if>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
