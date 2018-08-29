import { ShopManagementModule } from './shop-management.module';

describe('ShopManagementModule', () => {
  let shopManagementModule: ShopManagementModule;

  beforeEach(() => {
    shopManagementModule = new ShopManagementModule();
  });

  it('should create an instance', () => {
    expect(shopManagementModule).toBeTruthy();
  });
});
