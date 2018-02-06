/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { JhipsterSampleApplicationTestModule } from '../../../test.module';
import { RNS_PCH_MASTERComponent } from '../../../../../../main/webapp/app/entities/rns-pch-master/rns-pch-master.component';
import { RNS_PCH_MASTERService } from '../../../../../../main/webapp/app/entities/rns-pch-master/rns-pch-master.service';
import { RNS_PCH_MASTER } from '../../../../../../main/webapp/app/entities/rns-pch-master/rns-pch-master.model';

describe('Component Tests', () => {

    describe('RNS_PCH_MASTER Management Component', () => {
        let comp: RNS_PCH_MASTERComponent;
        let fixture: ComponentFixture<RNS_PCH_MASTERComponent>;
        let service: RNS_PCH_MASTERService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [JhipsterSampleApplicationTestModule],
                declarations: [RNS_PCH_MASTERComponent],
                providers: [
                    RNS_PCH_MASTERService
                ]
            })
            .overrideTemplate(RNS_PCH_MASTERComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(RNS_PCH_MASTERComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(RNS_PCH_MASTERService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new RNS_PCH_MASTER(123)],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.rNS_PCH_MASTERS[0]).toEqual(jasmine.objectContaining({id: 123}));
            });
        });
    });

});
