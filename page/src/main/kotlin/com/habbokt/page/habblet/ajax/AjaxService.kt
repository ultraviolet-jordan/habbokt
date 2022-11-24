package com.habbokt.page.habblet.ajax

import com.habbokt.page.PageService

/**
 * @author Jordan Abraham
 */
abstract class AjaxService constructor(
    page: AjaxPage
) : PageService<AjaxPage>(page, null)