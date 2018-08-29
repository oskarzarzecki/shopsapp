import { ShopCustomerModule } from './shop-customer.module';

describe('ShopModule', () => {
  let shopCustomerModule: ShopCustomerModule;

  beforeEach(() => {
    shopCustomerModule = new ShopCustomerModule();
  });

  it('should create an instance', () => {
    expect(shopCustomerModule).toBeTruthy();
  });
});
