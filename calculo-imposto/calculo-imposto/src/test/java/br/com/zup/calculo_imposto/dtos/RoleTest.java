package br.com.zup.calculo_imposto.dtos;

import org.junit.jupiter.api.Test;

public class RoleTest {
    private Role role;

    @Test
    public void RoleTest() {
        assertEquals("ROLE_ADMIN", Role.ROLE_ADMIN.getRoleName());
        assertEquals("ROLE_USER", Role.ROLE_USER.getRoleName());
    }
}
